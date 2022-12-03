package cn.exiafor.zhxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    /**
     * 解决Linux平台运行时新上传文件没有办法被新请求获取的问题
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if ("Linux".equals(System.getProperty("os.name"))) {
            String imgPath = System.getProperty("user.dir") + "/target/classes/public/upload/";

            registry.addResourceHandler("/upload/**")
                    .addResourceLocations("file:" + imgPath);
        }
    }
}
