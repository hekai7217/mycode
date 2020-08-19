package com.sxt.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author 黄药师
 * @date 2020-08-19 9:30
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   处理图片上传:
 *     1. 导入 apache的 commons-upload jar
 *     2. 页面的文件提交
 *           1. 必须是post 提交
 *           2. enctype  (多文件 multipart/form-data)
 *           3. 表单域中要用 type = "file"
 *
 *     3. 用 MultipartFile  接受图片
 *
 *     4. 配置图片解析器 来解析
 *
 *     5. 把图片保存
 *
 */
@Controller
public class Demo01Controller {


    // 写方法 处理 图片上传
    @RequestMapping("img01")
    public String uploadImage(MultipartFile img,String name){

        // 看一下文件的信息
        // 文件的名称
        String fname = img.getName();
        System.out.println(fname);
        // 最初的 名称
        System.out.println(img.getOriginalFilename());
        // 文件大小
        System.out.println(img.getSize());
        // 如何保存
        // mvc 保存图片到本地 ( 实际开发中 图片要保存到 图片服务器中,返回一个url  把这个url存到数据库中 )

        // 1. 创建文件夹存储图片
        File dest = new File("c:/upload");
        if (!dest.exists()){  //创建文件
            //创建文件
            dest.mkdirs();
        }

        //2 file ?  file的名称  / file的文件类型
        //   file的名称  最好唯一   使用uuid 给文件取名称
        String fName = UUID.randomUUID().toString().replaceAll("-", "");
        //  file的文件类型
        // 0.jpg
//        String str = img.getOriginalFilename();
//        int index = str.lastIndexOf(".");
//        // 拿到后缀
//        String suff = str.substring(index);
        // 这里从操作和上面的截取一样的   截取的是后缀 没有包含 .
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        // 名称的名称是: name + "." + 后缀
        String fn = fName + "." + extension;
        // 这个文件要放到    文件夹存储图片
        File f = new File(dest, fn);
        // 3.  把文件 存到file中
        try {
            img.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/view/success.jsp";
    }

    /**
     *  多文件上传 保存的时候 用for 进行操作
     * @param imgs
     * @param name
     * @return
     */
    @RequestMapping("img02")
    public String uploadImage02(MultipartFile[] imgs,String name){

        for (MultipartFile img : imgs) {

            // mvc 保存图片到本地 ( 实际开发中 图片要保存到 图片服务器中,返回一个url  把这个url存到数据库中 )

            if(img != null){
                // 1. 创建文件夹存储图片
                File dest = new File("c:/upload");
                if (!dest.exists()){  //创建文件
                    //创建文件
                    dest.mkdirs();
                }

                //2 file ?  file的名称  / file的文件类型
                //   file的名称  最好唯一   使用uuid 给文件取名称
                String fName = UUID.randomUUID().toString().replaceAll("-", "");
                //  file的文件类型
                // 0.jpg
//        String str = img.getOriginalFilename();
//        int index = str.lastIndexOf(".");
//        // 拿到后缀
//        String suff = str.substring(index);
                // 这里从操作和上面的截取一样的   截取的是后缀 没有包含 .
                String extension = FilenameUtils.getExtension(img.getOriginalFilename());
                // 名称的名称是: name + "." + 后缀
                String fn = fName + "." + extension;
                // 这个文件要放到    文件夹存储图片
                File f = new File(dest, fn);
                // 3.  把文件 存到file中
                try {
                    img.transferTo(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/view/success.jsp";
    }

    // 图片下载

    /**
     *  图片下载 (了解 )
     *
     *    1. 读取图片的io
     *    2. 把图片写入到浏览器
     *
     * @return
     */
    @RequestMapping("img03")
    public void load(HttpServletRequest req,HttpServletResponse resp){

        //4.响应的内容应该是以附件的形式响应给浏览器(设置响应头)
        // 浏览器自动保存 回写文件
        resp.setHeader("Content-Disposition", "attachment;filename=0.jpg");
        // 读取图片
        ServletContext servletContext = req.getServletContext();

        InputStream is = null;
        ServletOutputStream oos = null;

        try {
        // 获取输入流
         is = servletContext.getResourceAsStream("/img/0.jpg");
         oos  = resp.getOutputStream();

         //回写
//         // io操作
//         byte [] b = new byte[1024];
//         int len = 0 ;
//         while ((len = is.read(b))!=-1){
//             oos.write(b,0,len);
//         }
//         oos.flush();
            // 工具类 可以直接把输入流 写到 输出流流中

            IOUtils.copy(is,oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
