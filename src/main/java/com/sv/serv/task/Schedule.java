package com.sv.serv.task;


import com.sv.serv.common.MailUtil;
import com.sv.serv.controller.LocalController;
import com.sv.serv.model.ToolAlive;
import com.sv.serv.service.MegapolisServImpl;
import com.sv.serv.service.SvDataServImpl;
import com.sv.serv.service.SwitchServImpl;
import com.sv.serv.service.ZukServImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.sv.serv.common.SVUtil.tabletOnLan;

@Log4j2
@Component
public class Schedule {
	@Autowired
	MegapolisServImpl megapolisServ;
	@Autowired
	SvDataServImpl svDataServ;
	@Autowired
	ZukServImpl zukServ;
	@Autowired
	SwitchServImpl switchServ;

//    @Autowired
//    public Schedule(SwitchServ switchServ, MegapolisServ megapolisServ, SvDataServ svDataServ, ZukServ zukServ) {
//        this.megapolisServ = megapolisServ;
//        this.svDataServ = svDataServ;
//        this.zukServ = zukServ;
//        this.switchServ = switchServ;
//    }

	@Scheduled(cron = "0 1 1 * * ?") // 每天01:01执行
	public void job1 ( ) {
		try {
//			svDataServ.syncDb();
			log.error( "syncDb success" );
		} catch ( Exception e ) {
			log.error( "syncDb has error " + e.getMessage() );
		}
	}

	@Scheduled(cron = "0 0/10 * * * ?") // 间隔10分钟执行
	public void job2 ( ) {
		try {
			if ( !switchServ.getCheckRunning() ) {
				return;
			}
			if ( switchServ.checkGiftSending() ) {
				log.info( "i'm running" );
				return;
			}
			String ids = megapolisServ.getUnsentDay();
			if ( switchServ.checkRemainSim( ids ) ) {
				new LocalController().os_reboot();
				log.info( "reboot" );
			}
		} catch ( Exception e ) {
			log.error( "check sending has error " + e.getMessage() );
		}
	}

	@Scheduled(cron = "0 1 0 * * ?") // 每天00:01执行
	public void job3 ( ) {
		try {
			if ( switchServ.getWakeUpTablet() ) {
				tabletOnLan( "0862664c59cb" );
				log.info( "Start PC" );
			}
		} catch ( Exception e ) {
			log.info( "Start PC has error " + e.getMessage() );
		}
	}

	@Scheduled(cron = "0 0/15 * * * ?") // 间隔15分钟执行
	public void job4 ( ) {
		try {
			if ( !switchServ.getCheckZuk() ) {
				return;
			}
			if ( System.currentTimeMillis() / 1000 - Long.parseLong( zukServ.getToolHeart( new ToolAlive( "com.sv.mp.shc", "SV", "1", "" ) ) ) > 900 ) {
				MailUtil.sendEmail( "Zuk停止了", "Zuk停止了" );
			}
		} catch ( Exception e ) {
			log.error( "getToolAlive has error " + e.getMessage() );
		}
	}
}