# Swagger

- FrontEnd와 BackEnd 개발자 분리하여 api목록을 웹에서 확인 및 테스트하는 Library

#### Dependency 추가

```xml
<!-- swagger를 위한 의존성 추가. springfox로 검색 -->
//SwaggerConfig에 @EnableSwagger2 3.0 이상은 생략해도된다.
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>3.0.0</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>3.0.0</version>
		</dependency>

```



## SwaggerController

```java
@RestController
//@Controller
@RequestMapping("/admin") // Mapping을 admin으로 하고 config에서 Swagger를 설정한다.
@CrossOrigin("*")
@Api(tags = {"어드민 컨트롤러  API V1"}) // 
public class AdminUserController {
```

- @RestController REST Controller인 것을 표시해준다.
- @RequestMapping SwaggerConfig pahts 이름과 동일하게해준다.
- @CrossOrigin CrossDomain을 요청하는 것. 외부도메인을 접근 허용해준다.
- @Api 화면에 상단에 표시될 제목

## SwaggerConfig

```java
@Configuration
public class SwaggerConfiguration {
@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName(version).select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.admin.controller"))
					.paths(regex("/admin/.*")).build()
					.useDefaultResponseMessages(false);
	}
```

- Configuration bean을 수정할 수있다.
- basdePackage와 paths를 다른 프로젝트를 적용시 바꾸어주면 된다.

## DTO

```java
@ApiModel(value = "MemberDto (회원정보)", description = "아이디, 비번, 이름을 가진   Domain Class")
```

- 상호 가독성을 위하여 DTO의 설명을 해준다.
