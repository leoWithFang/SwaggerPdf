# SwaggerPdf
用swagger2markup导出html，pdf的离线文档。

# 如何运行
下载本项目之后，修改pom.xml中的
<properties>
swagger.input属性值中的ip和port
<properties>
 执行mvn clean test完成之后，会在/target/asciidoc/pdf/目录下生成index.pdf，该pdf文件即是生成的swagger项目接口的文档。  
 备注：本项目的pom.xml配置中默认生成中文的离线文档，如果只需要生成英文文档，将swagger2markup.outputLanguage的值改为EN即可。
# 修复生成pdf时中文缺失的bug
把本地maven仓库路径⁨.m2⁩/⁨repository⁩/org⁩/asciidoctor⁩/⁨asciidoctorj-pdf⁩/1.5.0-alpha.16⁩/文件夹下的asciidoctorj-pdf-1.5.0-alpha.16.jar
替换为src/jar下的asciidoctorj-pdf-1.5.0-alpha.16.jar。
# 如何定制字体并在pdf中用自定义字体
打开asciidoctorj-pdf-1.5.0-alpha.16.jar，在该文件中的/gems/asciidoctor-pdf-1.5.0.alpha.10/data/fonts/文件目录下加入自己的tff字体文件，
然后修改/gems/asciidoctor-pdf-1.5.0.alpha.10/data/themes下面的default-theme.yml配置文件，
第四行Noto Serif中的四个属性（normal，bold，italic，bold_italic）替换为自定义字体的文件名即可。
 # 调用接口生成离线文档
 修改配置文件中的maven.home。
 新增TestController类，里面有createPdf方法，调用该方法后java代码调用maven命令进行离线文档生成。


