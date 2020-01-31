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

```bash
http POST http://localhost:8080/graphql query='{foods{id,name}}' 'Authorization: <your_access_token>'
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
