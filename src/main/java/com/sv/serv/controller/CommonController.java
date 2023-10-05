package com.sv.serv.controller;


import com.alibaba.fastjson.JSONObject;
import com.sv.serv.common.JsonUtil;
import com.sv.serv.common.MailUtil;
import com.sv.serv.common.ResponseCode;
import com.sv.serv.common.ResponseData;
import com.sv.serv.model.FileParams;
import com.sv.serv.model.SwitchInfo;
import com.sv.serv.model.UpdateInfo;
import com.sv.serv.service.SwitchServImpl;
import com.sv.serv.service.UpdateInfoServImpl;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static com.sv.serv.common.SVUtil.tabletOnLan;


@RestController
@RequestMapping("/")
public class CommonController {

    private static final Logger log = LogManager.getLogger("common");
    @Autowired
    UpdateInfoServImpl updateInfoServ;
    @Autowired
    SwitchServImpl switchServ;


    @RequestMapping(value = "/Health")
    public String Health() {
        return "OK";
    }


    @RequestMapping(value = "/bL")
    public ResponseData bL() {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        result.setData("启动笔记本：" + tabletOnLan("2c600ce84990"));
        log.info("start laptop success");
        return result;
    }

    @RequestMapping(value = "/bT")
    public ResponseData bT() {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        result.setData("启动台式机：" + tabletOnLan("0862664c59cb"));
        log.info("start tablet success");
        return result;
    }

    @RequestMapping(value = "/wol")
    public ResponseData wol(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        String wol = switch (request.getParameter("mac")) {
            case "1" -> "2c600ce84990";
            case "2" -> "0862664c59cb";
            case "3" -> "00E07025B55B";
            default -> "";
        };
        result.setData("启动设备：" + tabletOnLan(wol));
        log.info("start computer success");
        return result;
    }


    @RequestMapping(value = "/ddns")
    public ResponseData ddns(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String domain = request.getParameter("domain");
            String ip = request.getParameter("ip");
            SwitchInfo switchInfo = new SwitchInfo("fun-" + domain, ip, "");
            log.info("ddns param is > " + switchInfo);
            switchServ.setSwitch(switchInfo);
            MailUtil.sendEmail("【DDNS Change】", domain + " ip is " + ip);
            log.info("ddns success");
        } catch (Exception e) {
            log.error("ddns has error > " + e);
        }
        return result;
    }

    @RequestMapping(value = "/bookDownloadNotice")
    public ResponseData bookDownloadNotice(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String bookName = request.getParameter("bookName");
            MailUtil.sendEmail("【书籍下载完毕通知】", "【" + bookName + "】下载完毕。");
            log.info("bookDownloadNotice success");
        } catch (Exception e) {
            log.error("bookDownloadNotice has error > " + e);
        }
        return result;
    }

    @RequestMapping(value = "/bookFinish")
    public ResponseData bookFinish(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String bookName = request.getParameter("bookName");
            MailUtil.sendEmail("【书籍完本通知】", "【" + bookName + "】疑似完本，请确认。");
            log.info("bookFinish success");
        } catch (Exception e) {
            log.error("bookFinish has error > " + e);
        }
        return result;
    }

    @RequestMapping(value = "/ipv6")
    public ResponseData ipv6(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String domain = request.getParameter("domain");
            String ip = request.getParameter("ip");
            SwitchInfo switchInfo = new SwitchInfo("ip-" + domain, ip, "");
            log.info("ipv6 param is > " + switchInfo);
            switchServ.setSwitch(switchInfo);
            log.info("ipv6 success");
        } catch (Exception e) {
            log.error("ipv6 has error > " + e);
        }
        return result;
    }

    @RequestMapping(value = "/computerStart")
    public ResponseData computerStart(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String name = request.getParameter("name");
            log.info("computerStart > " + name);
            MailUtil.sendEmail("【" + name + " Start】", name + " has start.");
            log.info("computerStart success");
        } catch (Exception e) {
            log.error("computerStart has error > " + e);
        }
        return result;
    }

    @RequestMapping(value = "/computerStop")
    public ResponseData computerStop(HttpServletRequest request) {
        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
        try {
            String name = request.getParameter("name");
            log.info("computerStop > " + name);
            MailUtil.sendEmail("【" + name + " Stop】", name + " has stop.");
            log.info("computerStop success");
        } catch (Exception e) {
            log.error("computerStop has error > " + e);
        }
        return result;
    }


    @RequestMapping(value = "/download/{name}")
    public String download(@PathVariable String name, HttpServletResponse response) {
        String msg = "OK";
        String filename = "/opt/data/up&down/" + name;
        log.info("start download > " + filename);
        byte[] data = getFileByteArray(filename);
        try {
            if (data == null) {
                throw new FileNotFoundException("文件没有找到！");
            }
            response.setContentType("application/binary;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name, StandardCharsets.UTF_8));
            response.setContentLength(data.length);
            response.getOutputStream().write(data);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            msg = "ERROR";
            log.error("download has error > " + e);
        }
        return msg;
    }

    /**
     * 文件上传,springmvc方式
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request) {
        String msg = "OK";
        try {
            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            if (multipartRequest != null) {
                MultipartFile upload = multipartRequest.getFile("file");
                if (upload != null) {
                    //获取上传文件的名称
                    String filename = upload.getOriginalFilename();
                    if (filename != null) {
                        log.info("upload file name is > " + filename);
                        //指定文件上传的位置
                        String path = "/opt/data/up&down/";
                        //判断该路径是否存在
                        File file = new File(path);
                        if (!file.exists()) {
                            log.info("addLogs file path not exist");
                            //不存在就创建一个路径
                            if (!file.mkdirs()) {
                                throw new RuntimeException("创建路径失败");
                            }
                        }
                        //说明上传文件项
                        //完成上传文件
                        File upFile = new File(path, filename);
                        upload.transferTo(upFile);
                        UpdateInfo updateInfo = new UpdateInfo();
                        updateInfo.setToolName(filename.substring(0, filename.length() - 4));
                        updateInfo.setFileSize(String.valueOf((upFile.length() / 1024 / 1024) + 1));
                        updateInfo.setUpdateTime(String.valueOf(System.currentTimeMillis() / 1000));
                        updateInfoServ.setUpdateInfo(updateInfo);
                        log.info("upload file success & file length is " + upFile.length());
                    }
                }
            }
        } catch (Exception e) {
            msg = "ERROR";
            log.error("upload has error > " + e);
        }
        return msg;
    }

    @RequestMapping(value = "/newLogs", method = RequestMethod.POST)
    public String newLogs(HttpServletRequest request) {
        FileParams fileParams = JSONObject.parseObject(new JsonUtil().Map2String(request.getParameterMap()), FileParams.class);

        String name = fileParams.getFileName();
        String[] paths = name.split("-");
        Path path = Path.of("/opt/data/logs/Serv/", paths[0], paths[1]);
        File file = new File(path.toString());
        if (!file.exists()) {
            log.info("newLogs file not exists");
            //不存在就创建一个路径
            if (!file.mkdirs()) {
                throw new RuntimeException("创建路径失败");
            }
        }
        log.info("newLogs success");
        return "OK";
    }

    @RequestMapping(value = "/addLogs/{paths}", method = RequestMethod.PUT)
    public String addLogs(HttpServletRequest request, @PathVariable String paths) {
        String msg = "OK";
//		int seed = Integer.parseInt( request.getHeader( "User-Agent" ).substring( 5, 10 ) );
//		String[] b = paths.split( "," );
//		String c = StrDecode( b, seed, "" );
        log.info("addLogs in param > " + paths);
        String[] v_paths = paths.split("--");
        try {
            StringBuilder content = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
            int i;
            char ch;
            while ((i = inputStreamReader.read()) != -1) {
                ch = (char) i;
                content.append(ch);
            }
            log.info("addLogs file name is > " + v_paths[2]);
            //指定文件上传的位置
            Path path = Path.of("/opt/data/logs/Serv/", v_paths[0], v_paths[1]);
            log.info("addLogs file path is" + path);
            File dir = new File(path.toString());
            //判断该路径是否存在
            if (!dir.exists()) {
                //不存在就创建一个路径
                log.info("addLogs file path not exist");
                if (!dir.mkdirs()) {
                    throw new RuntimeException("创建路径失败");
                }
            }
            File file = new File(dir, v_paths[2]);
            //说明上传文件项
            //完成上传文件
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            osw.write(content.toString());
            osw.close();
            log.info("addLogs file success");
        } catch (Exception e) {
            msg = "ERROR";
            log.error("addLogs has error > " + e);
        }
        return msg;
    }

    /**
     * 下载文件
     */
    public byte[] getFileByteArray(String filename) {
        File file = new File(filename);
        InputStream input = null;
        byte[] data = null;
        try {
            if (!file.exists())
                return null;
            input = new FileInputStream(file);
            data = IOUtils.toByteArray(input);
        } catch (IOException e) {
            log.error("getFileByteArray has error > " + e);
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e1) {
                    log.error("getFileByteArray has error > " + e1);
                }
            }
        }
        return data;
    }

}


