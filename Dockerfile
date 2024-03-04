FROM openjdk:17
ADD target/adm-azs-shipping.jar adm-azs-shipping
ENTRYPOINT [ "java", "-jar", "adm-azs-shipping" ]
