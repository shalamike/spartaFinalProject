# spartaFinalProject

## Table of Contents

1. About
2. General Requirements
3. API Endpoints
4. Contributing

## About

Developed by Tech 219.

The application searches for request data from a MongoDB database `sample_mflix` and presents it to the user.

Purpose:
- Using Spring Boot and appropriate testing methods
- Exploring the concepts of REST
- Exploring Thymeleaf

## General Requirements
This is a proof of concept project.

The product owner wants to explore the possibility of having a MongoDB and cloud-based solution for accessing information about movies, allowing users to post or read comments on movies and managing a film schedule for cinemas.

A sample database (sample_mflix) is provided which includes details of movies, comments, "theaters" and users.

Two products are required: - A RESTful API which allows full CRUD access to the existing data for these 4 collections - A Web application providing a browser-based interface to the same set of existing collections

Additionally, a new feature is required to allow an administrator to create a schedule for a theatre, adding films to the roster and specifying showing times. No ticketing system is required at this point in the project. The cinema film scheduling feature should also be provided through both interfaces (REST & Web).

### Required Technologies
The persistence mechanism must be MongoDB
The database must be hosted on MongoDB Atlas using the "Shared" (free) tier hosted on AWS
The database must be based on the sample_mflix database, which is provided for use within MongoDB - this tutorial explains how to install the sample
Spring Boot must be used for the API and Web front ends
Spring Data MongoDB must be used for accessing the database from both the API and the Web application
The code repository for the project must be hosted on GitHub
## API Endpoints

### Movies

The following table shows the endpoints available relating to the `movies` collection:
| HTTP Verbs  | Endpoints | Action |
| ----------- | --------- |  ----- |
| POST | /api/movie | To create a new movie, submit the entry via the request body, see JSON format for entries below |
| GET | /api/movie/{id} | To retrieve a movie by its `id` |
| GET | /api/movie/title/{title} | To retrieve movies by its `title` |
| PUT | /api/movie/{id} | To update a movie, provide its `id` as a path variable, then specify the field to be updated in the request body (see JSON format below)|
| DELETE | /api/movie/{id} | To delete a movie by its `id` |
| GET | /web/movies/titles/{title} | To retrieve movies by its `title` |
| GET | /web/movie/create | To create a movie via a form |



NOTE: When entering dates for `released` and `tomatoes.lastUpdated` the following format must be used `yyyy-MM-dd'T'HH:mm`


NOTE: The following is the JSON document below demonstrates required format for entering the attributes of a movie. The only required fields to create a movie are `title`, `year` and `type`, all other attributes are optional.
```
{
  "_id": "573a1390f29313caabcd4323",
  "title": "The Land Beyond the Sunset",
  "year": 1912,
  "type": "movie",
  "numMflixComments": 1,
  "directors": ["Harold M. Shaw"],
  "cast": ["Martin Fuller","Mrs. William Bechtel","Walter Edwin","Ethel Jewett"],
  "languages": ["English"],
  "runtime": 14,
  "writers": ["Dorothy G. Shore"],
  "countries": ["USA"],
  "rated": "UNRATED",
  "tomatoes": {
    "viewer": {
      "meter": 67,
      "rating": 3.7,
      "numReviews": 53
    },
    "lastUpdated": "2015-04-27T19:06:35.000+00:00"
  },
  "fullplot": "Thanks to the Fresh Air Fund, a slum child escapes his drunken mother for a day's outing in the country. Upon arriving, he and the other children are told a story about a mythical land of no pain. Rather then return to the slum at day's end, the lad seeks to journey to that beautiful land beyond the sunset.",
  "imdb": {
    "rating": 7.1,
    "votes": 448,
    "id": 488
  },
  "plot": "A young boy, opressed by his mother, goes on an outing in the country with a social welfare group where he dares to dream of a land where the cares of his ordinary life fade.",
  "genres": ["Short","Drama","Fantasy"],
  "awards": {
    "wins": 1,
    "text": "1 win.",
    "nominations": 0
  },
  "lastupdated": "2015-08-29 00:27:45.437000000",
  "poster": "https://m.media-amazon.com/images/M/MV5BMTMzMDcxMjgyNl5BMl5BanBnXkFtZTcwOTgxNjg4Mg@@._V1_SY1000_SX677_AL_.jpg",
  "released": "1912-10-28T00:00:00.000+00:00"
}
```
### Theaters
The following table shows the endpoints available relating to the `theaters` collection:
| HTTP Verbs  | Endpoints | Action |
| ----------- | --------- |  ----- |
| POST | /api/theaters/ | To create a new theater, submit the entry via the request body, see JSON format for entries below |
| GET | /api/theaters/ | To retrieve all theaters |
| GET | /api/theaters/id/{id} | To retrieve a theater by its object `id` |
| GET | /api/theaters/theaterid/{theaterid} | To retrieve theaters by its  `theaterId` |
| PUT | /api/theaters/theaterid/{theaterid} | To update a theater by its  `theaterId` as a path variable, then specify the field to be updated in the request body (see JSON format below)|
| PUT | /api/theaters/id/{id} | To update a theater by its object `id` as a path variable, then specify the field to be updated in the request body (see JSON format below)|
| DELETE | /api/theaters/id/{id}| To delete a theater by its object `id` |
| DELETE | /api/theaters/theaterid/{theaterid} | To delete a theater by its `theaterId` |

json format for theater
```
{
    "theaterId": 1003,
    "location": {
        "geo": {
            "coordinates": [
                -76.512016,
                38.29697
            ],
            "type": "Point"
        },
        "address": {
            "zipcode": "20619",
            "city": "California",
            "street1": "45235 Worth Ave.",
            "state": "MD"
        }
    },
    "_id": "59a47286cfa9a3a73e51e72d"
}
```


### Comments
The following table shows the endpoints available relating to the `comments` collection:
| HTTP Verbs  | Endpoints | Action |
| ----------- | --------- |  ----- |
| POST | /api/comment | To create a new comment, submit the entry via the request body, see JSON format for entries below |
| GET | /api/comment/{id} | To retrieve a comment by its `id` |
| GET | /api/comments | To retrieve all comments |
| GET | /api/comments/movie/{id} | To retrieve all comments for a particular movie, by the movie's `id` |
| PUT | /api/comment/{id} | To update a comment, provide its `id` as a path variable, then specify the field to be updated in the request body (see JSON format below)|
| DELETE | /api/comment/{id} | To delete a comment by its `id` |

JSON format for a comment:
```
{
  "date": "1985-02-24T20:04:25.000+00:00",
  "name": "Ellaria Sand",
  "_id": "5a9427648b0beebeb6957bb6",
  "text": "Quidem nesciunt quam atque officia vel laboriosam. Ipsam vel placeat dignissimos. Quo pariatur dolore deleniti impedit.",
  "movie_id": null,
  "email": "indira_varma@gameofthron.es"
}
```

### Users

## Contributing
