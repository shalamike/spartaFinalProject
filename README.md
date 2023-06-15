# spartaFinalProject

## Table of Contents

1. About
2. General Requirements
3. API Endpoints
4. Contributing

## About
## General Requirements
## API Endpoints

### Movies

The following table shows the endpoints available relating to the `movies` collection:
| HTTP Verbs  | Endpoints | Action |
| ------------- | ------------- |  ------------- |
| POST | /movie | To create a new movie |
| GET | /movie/{id} | To retrieve a movie by its `id` |



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
### Comments
### Sessions
### Users

## Contributing
