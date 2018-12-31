# SwaggerPdf
用swagger2markup导出html，pdf的离线文档。
把本地maven仓库路径⁨.m2⁩/⁨repository⁩/org⁩/asciidoctor⁩/⁨asciidoctorj-pdf⁩/1.5.0-alpha.16⁩/文件夹下的asciidoctorj-pdf-1.5.0-alpha.16.jar
替换为src/jar下的asciidoctorj-pdf-1.5.0-alpha.16.jar。
# 如果想定制字体
打开asciidoctorj-pdf-1.5.0-alpha.16.jar，在该文件中的/gems/asciidoctor-pdf-1.5.0.alpha.10/data/fonts/文件目录下加入自己的tff字体文件，
然后修改/gems/asciidoctor-pdf-1.5.0.alpha.10/data/themes下面的default-theme.yml配置文件，
第四行Noto Serif中的四个属性（normal，bold，italic，bold_italic）替换为自定义字体的文件名即可。

