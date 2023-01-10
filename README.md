![image](https://user-images.githubusercontent.com/83771741/206526399-63d0c851-218a-4320-8420-b538723e9e49.png)

# Twitter micro-services

Twitter is a microblogging and social networking service on which users post and interact with messages known as "tweets".

This app have 5 blocks or microservices which perform different task inside the app. Twitter-catalog-service works as the glue or the bridge that integrates these separate microservices, and the api-gateway file is a the one who sits between the client and the microservices to act as a reverse proxy, routing requests from clients to services.

## HTTP Methods

HTTP methods define the types of actions that can be performed on a resource.

*   **GET** method retrieves data from a resource.  
    Example:
        `GET /api/tweet/all` will get a list of all the tweet created.
*   **POST** method requests the server to insert a resource into the database.  
    Example:
        `POST /api/user` can be used to insert one or more users into the database.
*   **PUT** method requests the server to update a resource or create it if it doesn't exist.  
    Example:
        `PUT /api/tweet/add-comment/:tweet_id` will update the tweet info adding a new comment value.
*   **PATCH** method requests the server to partially update a resource in the database.  
    Example:
        `PATCH /api/admin/:admin_id/area` will update the department info of the Admin with the one that receives in the DTO object.
*   **DELETE** method requests the server to delete a resource from the database.  
    Example:
        `DELETE /api/user/:user_id` can be used by the Admin to delete user accounts by id.

## Microservices - Routes List

![microservices-diagram](https://user-images.githubusercontent.com/83771741/211558388-1188a1e4-1358-4ad9-9f6e-9c6bddf8754f.jpg)

### Discovery-service | Eureka is the Netflix Service Discovery Server | server.port=8761

| Method     | URI                                     | Microservice                                                  |
|------------|-----------------------------------------|---------------------------------------------------------------|
| `*`        | 8080/api/tweet                          | api-gateway                                                   |
| `*`        | 8083/api/tweet                          | twitter-catalog-service                                       |
| `*`        | 8082/api/tweet                          | tweet-data-service                                            |
| `*`        | 8081/api/tweet                          | account-data-service                                          |


### api-gateway | Eureka Netflix Service Discovery Client

| Method     | URI                                    | Action                                                        |
|------------|----------------------------------------|---------------------------------------------------------------|
| `*`        | /api/**                                | api-gateway/GatewayConfiguration                              |

### Twitter-catalog-service | Eureka Netflix Service Discovery Client

| Method     | URI                                    | Action                                                        |
|------------|----------------------------------------|---------------------------------------------------------------|
| `POST`     | /api/tweet                             | twitter-catalog-service/controller/impl @createTweet          |
| `GET`      | /api/tweet/:tweet_id                   | twitter-catalog-service/controller/impl @getTweetById         |
| `GET`      | /api/tweet/all                         | twitter-catalog-service/controller/impl @getAllTweets         |
| `GET`      | /api/tweet/user/:user_id               | twitter-catalog-service/controller/impl @getTweetsByUser      |
| `PUT`      | /api/tweet/add-like/user_id/tweet_id   | twitter-catalog-service/controller/impl @likeTweet            |
| `GET`      | /api/tweet/likes/:user_id              | twitter-catalog-service/controller/impl @getTweetsLikedByUser |
| `PUT`      | /api/tweet/add-comment/tweet_id        | twitter-catalog-service/controller/impl @addComment           |
| `GET`      | /api/tweet/comments/:parent_tweet_id   | twitter-catalog-service/controller/impl @getTweetComments     |
| `DELETE`   | /api/tweet/:tweet_id                   | twitter-catalog-service/controller/impl @deleteTweet          |
| `POST`     | /api/user                              | twitter-catalog-service/controller/impl @createUser           |
| `PUT`      | /api/user/:user_id                     | twitter-catalog-service/controller/impl @updateUserInfo       |
| `GET`      | /api/user/:user_id                     | twitter-catalog-service/controller/impl @getUserById          |
| `GET`      | /api/user/all                          | twitter-catalog-service/controller/impl @getAllUsers          |
| `DELETE`   | /api/user/:user_id                     | twitter-catalog-service/controller/impl @deleteUser           |
| `POST`     | /api/admin                             | twitter-catalog-service/controller/impl @createAdmin          |
| `PUT`      | /api/admin/:admin_id                   | twitter-catalog-service/controller/impl @updateAdminInfo      |
| `PATCH`    | /api/admin/:admin_id/area              | twitter-catalog-service/controller/impl @updateAdminArea      |
| `GET`      | /api/admin/:admin_id                   | twitter-catalog-service/controller/impl @getAdminById         |
| `GET`      | /api/admin/all                         | twitter-catalog-service/controller/impl @getAllAdmin          |
| `DELETE`   | /api/admin/:admin_id                   | twitter-catalog-service/controller/impl @deleteAdmin          |

### Tweet-data-service | Eureka Netflix Service Discovery Client

| Method     | URI                                         | Action                                                   |
|------------|---------------------------------------------|----------------------------------------------------------|
| `POST`     | /api/tweet                                  | tweet-data-service/controller/impl @createTweet          |
| `GET`      | /api/tweet/:tweet_id                        | tweet-data-service/controller/impl @getTweetById         |
| `GET`      | /api/tweet/all                              | tweet-data-service/controller/impl @getAllTweets         |
| `GET`      | /api/tweet/user/:user_id                    | tweet-data-service/controller/impl @getTweetsByUser      |
| `PUT`      | /api/tweet/add-like/user_id/tweet_id        | tweet-data-service/controller/impl @likeTweet            |
| `GET`      | /api/tweet/likes/:user_id                   | tweet-data-service/controller/impl @getTweetsLikedByUser |
| `PUT`      | /api/tweet/add-comment/tweet_id             | tweet-data-service/controller/impl @addComment           |
| `GET`      | /api/tweet/comments/:parent_tweet_id        | tweet-data-service/controller/impl @getTweetComments     |
| `DELETE`   | /api/tweet/:tweet_id                        | account-data-service/controller/impl @deleteTweet        |

### Account-data-service | Eureka Netflix Service Discovery Client

| Method     | URI                                           | Action                                                 |
|------------|-----------------------------------------------|--------------------------------------------------------|
| `POST`     | /api/user                                     | account-data-service/controller/impl @createUser       |
| `PUT`      | /api/user/:user_id                            | account-data-service/controller/impl @updateUserInfo   |
| `GET`      | /api/user/:user_id                            | account-data-service/controller/impl @getUserById      |
| `GET`      | /api/user/all                                 | account-data-service/controller/impl @getAllUsers      |
| `DELETE`   | /api/user/:user_id                            | account-data-service/controller/impl @deleteUser       |
| `POST`     | /api/admin                                    | account-data-service/controller/impl @createAdmin      |
| `PUT`      | /api/admin/:admin_id                          | account-data-service/controller/impl @updateAdminInfo  |
| `PATCH`    | /api/admin/:admin_id/area                     | account-data-service/controller/impl @updateAdminArea  |
| `GET`      | /api/admin/:admin_id                          | account-data-service/controller/impl @getAdminById     |
| `GET`      | /api/admin/all                                | account-data-service/controller/impl @getAllAdmin      |
| `DELETE`   | /api/admin/:admin_id                          | account-data-service/controller/impl @deleteAdmin      |

## UML Class Diagram

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/83771741/206518364-f2c528c3-022e-4cd8-891b-83caf7512c2a.png">

## Use Case Diagram

<img width="700" alt="image" src="https://user-images.githubusercontent.com/83771741/206531258-5e64a8ef-1d40-4cd2-902c-7f1f07ecd74e.png">

## HTTP Responses

HTTP defines a set of Status Codes that must be included in your API responses to tell the developer that status of his/her request. Here are some of the commonly used Status Codes -

*   `200 OK` - GET, PUT, PATCH or DELETE was successful.
*   `201 Created` - POST request was successful.
*   `204 No Content` - DELETE was successful.
*   `400 Bad Request` - There were invalid parameters in the request. Developer must fix them.
*   `401 Unauthorized` - Invalid Credentials were provided.
*   `404 Not Found` - URL does not exist.
*   `405 Method Not Allowed` - Requested method is not allowed on the resource.
*   `500 Internal Server Error` - Problem with the server.

### Team members

<img width="100" alt="image" src="https://user-images.githubusercontent.com/83771741/206534567-008337ee-b791-4798-8b2c-a1ad62024290.png">

[Natalia Pinzon](https://github.com/nanuta522)<br>

### Collaborators
[Lead Teacher](https://github.com/Amaza-ing)<br>
[Teacher Assistants](https://github.com/ta-java-ih)

### Sources
IronHack Lessons<br>
[W3 Schools](https://www.w3schools.com/java/default.asp)<br>
[GeeksForGeeks](https://www.geeksforgeeks.org/java/?ref=ghm)<br>
[JavaTPoint](https://www.javatpoint.com/java-tutorial)
