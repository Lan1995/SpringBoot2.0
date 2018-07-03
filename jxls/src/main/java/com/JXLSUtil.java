package com;

import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JXLSUtil {


    public static void main(String[] args) {
        User user = new User();
        user.setUsername("AA");
        user.setAge(18);
        LinkAddress address1 = new LinkAddress();
        address1.setPhone("111");
        address1.setAddress("地址1");

        LinkAddress address2 = new LinkAddress();
        address2.setPhone("222");
        address2.setAddress("地址2");

        LinkAddress address3 = new LinkAddress();
        address3.setPhone("3");
        address3.setAddress("地址3");

        LinkAddress address4 = new LinkAddress();
        address4.setPhone("444");
        address4.setAddress("地址4");

        List<LinkAddress> list = new ArrayList<>();

        list.add(address1);
        list.add(address2);
        list.add(address3);
        list.add(address4);

        user.setList(list);

        Context context = PoiTransformer.createInitialContext();

        try (InputStream in = ClassUtils.class.getClassLoader().getResourceAsStream(".\\file\\a.xlsx")) {

            File file = new File("b.xls");
            OutputStream os = new FileOutputStream(file);

            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            Transformer transformer  = jxlsHelper.createTransformer(in, os);
            //获得配置
            JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator)transformer.getTransformationConfig().getExpressionEvaluator();
            //设置静默模式，不报警告
            //evaluator.getJexlEngine().setSilent(true);
            //函数强制，自定义功能
            Map<String, Object> funcs = new HashMap<>();
            funcs.put("vo", new JXLSUtil());    //添加自定义功能
            evaluator.getJexlEngine().setFunctions(funcs);
            //必须要这个，否者表格函数统计会错乱
            jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
