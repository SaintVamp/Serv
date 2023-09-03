package com.sv.serv;

import com.sv.serv.service.SwitchServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwitchServImplTest {
	@Autowired
	private SwitchServImpl switchServ;

//	@BeforeClass
//	public static void beforeClass ( ) {
//		System.out.println( "我先“执行”为敬！ -- -- by @BeforeClass" );
//	}
//
//	@AfterClass
//	public static void afterClass ( ) {
//		System.out.println( "测试案例都跑完了，该我执行了 -- by @AfterClass" );
//	}
//
//	@Before
//	public void before ( ) {
//		System.out.println( "我在每个案例前先执行 -- by @Before" );
//	}
//
//	@After
//	public void after ( ) {
//		System.out.println( "我在每个案例后执行 -- by @After" );
//	}
//
//	@Test
//	public void getSwitch_test_1 ( ) throws Exception {
//		System.out.println( "案例：输入开关ID查找开关状态" );
//		SwitchInfo switchInfo = new SwitchInfo( "auto_server", "", "" );
//		String result = switchServ.getSwitch( switchInfo );
//		assertEquals( "0", result );
//	}
//
//	@Test
//	public void getSwitch_test_2 ( ) throws Exception {
//		System.out.println( "案例：输入开关ID查找开关状态2" );
//		SwitchInfo switchInfo = new SwitchInfo( "daily_status", "", "" );
//		String result = switchServ.getSwitch( switchInfo );
//		assertEquals( "0", result );
//	}

}
