# TestTableSendData  

```no-highlight
這個簡單小專案主要是寫給朋友參考用的，
因為一直被朋友問到要怎麼撰寫原生JavaScript程式掃描整張table 特定的某幾列以後，
擷取出該列資料，組成JSON格式資料回傳到後端。

所以特此寫了一隻簡單版小型範例程式給朋友看。
使用的技術也 100% 配合朋友目前練習的程式。
網頁是由古老的 JSP技術 在 server side render 出畫面。
而後端程式則是由 Servlet去負責，
因為朋友還沒學到 Spring, SpringMVC, Spring Boot 這些 Framework，
所以我這次沒引進 Spring Framework 在專案裡面。

至於資料的部份，
我主要是演示前端網頁用 JavaScript程式 掃描整張 table資料後傳給後端。
所以本專案沒有連接資料庫，
而是以一個預先寫死的 static java.util.ArrayList物件 來充當從資料庫取得的資料。

專案建置工具：Maven

電腦環境
Apache Tomcat Server version：9.0.20
jdk version：1.8.0_202
jre version：1.8.0_202
IDE：Eclipse
IDE versioon：Eclipse Java EE IDE for Web Developers 2018-09 (4.9.0)
作業系統：Windows 10 家用版 21H1
系統類型：64 位元作業系統
```