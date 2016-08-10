import movieWebsite_fresh_tomatoes
import movieWebsite_media

toy_story = movieWebsite_media.Movie("Toy Story", "A story about toys that come to life", "http://vignette4.wikia.nocookie.net/pixar/images/c/ca/Toy_story_ver1_xlg.jpg/revision/latest?cb=20110515142143", "https://www.youtube.com/watch?v=KYz2wyBy3kc")
print("The story for the movie " + toy_story.title + " is: " + toy_story.storyline)
#toy_story.show_trailer()

avatar = movieWebsite_media.Movie("Avatar", "A marine on an alien planet", "http://www.masculinity-movies.com/wp-content/uploads/2010/02/avatar-movie-poster.jpg", "https://www.youtube.com/watch?v=d1_JBMrrYw8")
print("The story for the movie " + avatar.title + " is: " + avatar.storyline)
#avatar.show_trailer()

tyfs = movieWebsite_media.Movie("Thank You For Smoking", "A story about the lobbyist for Big Tobacco", "http://www.impawards.com/2006/posters/thank_you_for_smoking_ver5.jpg", "https://www.youtube.com/watch?v=s3eeTjK0qZY")
print("The story for the movie " + tyfs.title + " is: " + tyfs.storyline)
#tyfs.show_trailer()

Extracted = movieWebsite_media.Movie("Extracted", "A story about a machine that allows you to enter dreams", "http://lostinreviews.com/wp-content/uploads/2012/03/extracted.jpg", "https://www.youtube.com/watch?v=Q0jtvwSxLxI")
print("The story for the movie " + Extracted.title + " is: " + Extracted.storyline)
#Extracted.show_trailer()

IronMan = movieWebsite_media.Movie("Iron Man", "A story about Tony Stark being Iron Man", "http://vignette1.wikia.nocookie.net/marvelcinematicuniverse/images/1/1e/Iron_Man_Official_Poster.jpg/revision/latest?cb=20120115035645", "https://www.youtube.com/watch?v=8hYlB38asDY")
print("The story for the movie " + IronMan.title + " is: " + IronMan.storyline)
#IronMan.show_trailer()

megamind = movieWebsite_media.Movie("Megamind", "A story about a villan that becomes a hero", "http://api.comingsoon.net//images//2010/poster-42391-Megamind_7.jpg", "https://www.youtube.com/watch?v=GYFR4onjKmY")
print("The story for the movie " + megamind.title + " is: " + megamind.storyline)
#megamind.show_trailer()

movieWebsite_media.Movie.docs()
movieWebsite_media.Movie.name()
movieWebsite_media.Movie.mod()
movies = [toy_story, avatar, tyfs, Extracted, IronMan, megamind]
movieWebsite_fresh_tomatoes.open_movies_page(movies)
