# Java + GraphQL Example
 
This example app shows how to create a GraphQL API with Java and secure it with Okta.

Please read [How to GraphQL in Java](https://developer.okta.com/blog/2020/01/31/java-graphql) to see how this app was created.

**Prerequisites:** [Java 8](https://adoptopenjdk.net/) and an [Okta Developer Account](https://developer.okta.com/signup)

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone git@github.com:oktadeveloper/okta-graphql-java-example.git
cd okta-graphql-java-example
```

### Create an Application in Okta

Run the Okta Maven Plugin to create an account, register an OIDC app, and configure this app to use it.

```bash
./mvnw com.okta:okta-maven-plugin:setup
```

If you already have an account, you can do it manually.

1. Log in to your developer account on [developer.okta.com](https://developer.okta.com).
2. Navigate to **Applications** and click on **Add Application**.
3. Select **Web** and click **Next**. 
4. Give the application a name, add `http://localhost:8080/login/oauth2/code/okta` as a Login redirect URI, and click **Done**.

In the `src/main/resources/application.properties` file, add the settings from your new OIDC app. You won't need to do this step if you used the Okta Maven Plugin.

```yml
okta.oauth2.issuer=https://{yourOktaDomain}/oauth2/default
okta.oauth2.client-secret={yourClientSecret}
okta.oauth2.client-id={yourClientId}
```

Start the app using `./mvnw spring-boot:run`, navigate to `http://localhost:8080/my-access-token`, grab the token, and use it with HTTPie as follows:

http://localhost:7777/gui

{
   "Authorization": "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJfdENESFRlMmZTTnZJZWNfWUhnODNON3NMVHl5NHpldG9tWENKNmQ1Z1kwIn0.eyJleHAiOjE2MDA4MTQ3NTcsImlhdCI6MTYwMDgxMzI1NywiYXV0aF90aW1lIjoxNjAwODEzMTQ1LCJqdGkiOiJkZjMyZDhkMi0wNGVlLTQzZGItYjg5OS0xNGRiYjNlNzMwNDAiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvdHJhaW5pbmciLCJzdWIiOiIyNjU1MGE1Yy1mNTZmLTQ5MGUtOTQ4OC02MmI4Zjg5M2QxNmQiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcHAtZGVtby1ncmFwaHFsIiwibm9uY2UiOiJ4ZkZEMzl2ejFKVGxLV2NuNlVFUVRtWTBkNWQ0eEZLWWlleUlqUUFlN1VJIiwic2Vzc2lvbl9zdGF0ZSI6IjM2Yjc3MmMyLTlkNDItNGZiMy1hNGRhLTc4NzcxMDllOTVjMSIsImFjciI6IjAiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo3Nzc3Il0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJUaGVvIFRlc3RlciIsInByZWZlcnJlZF91c2VybmFtZSI6InRlc3RlciIsImdpdmVuX25hbWUiOiJUaGVvIiwiZmFtaWx5X25hbWUiOiJUZXN0ZXIiLCJlbWFpbCI6InRvbSt0ZXN0ZXJAbG9jYWxob3N0In0.twJI8c0xSbBoO6KPL8IVwsUkOq9x6wE2wnCQfBkO5igtuguYAWQjJPDfC92QdbboH0WQFkdydvzKRnBI2RIhn2HduD5QfxFL___M0ltVyQKNgWAIA7Qc8e1B9j-ed2FXkoOHRb3VmrLMC_6Fe_wuaQM1-Uah7SOxxUqqDgdfeFXnDc21dON3R6GrcU0fTJkCK9yKV-Fz1q1EEtpbkwGg4pW-Znmh11_jSdYI380Uod3uvBIUkClU7aTH23Jsu0UC08LyzFhBNv2Jif0-9iqn5Vv-6SKTV99wPAybu7W3dKHrwHsDRUeZDBeMzVeEsIo7yGQkTA_1Lfq1PgqTjNbxcQ"
}

```bash
$ http POST http://localhost:7777/graphql query='{foods{id,name}}' "Authorization: Bearer $TOKEN"  --ignore-stdin 
{"data":{"foods":[{"id":1,"name":"Pizza"},{"id":2,"name":"Spam"},{"id":3,"name":"Eggs"},{"id":4,"name":"Avocado"}]}}
```

For more information, please read this repo's associated blog post.

## Links

This example uses the following open source libraries:

* [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2020/01/31/java-graphql), or visit our [Okta Developer Forums](https://devforum.okta.com/). 

## License

Apache 2.0, see [LICENSE](LICENSE).
