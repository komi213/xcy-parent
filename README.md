# maven父子结构的一个demo项目

1. myjpadao子项目：JPA Respository层。
2. model子项目:实体层。
3. user子项目:spring boot 微服务。
4. order子项目:spring boot 微服务。
说明：model被myjpadao引入使用，user和order都引入myjpadao，也间接引用了model。所以，无需在user和order中显示引用model。
