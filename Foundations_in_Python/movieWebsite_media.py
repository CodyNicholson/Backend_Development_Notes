import webbrowser

class Movie():
    """This class provides a way to store movie related information"""
    
    VALID_RATINGS = ["G", "PG", "PG-13", "R"] #Class variable in caps, constant

    def __init__(self, movie_title, movie_storyline, poster_image, trailer): #Constructor that gets called upon defining a new instance of the class
        self.title = movie_title #Instance variable lowercase, dynamic
        self.storyline = movie_storyline
        self.poster_image_url = poster_image
        self.trailer_youtube_url = trailer

    def show_trailer(self):
        webbrowser.open(self.trailer_youtube_url)

    def docs(): #prints the class docs defined as " This class provides a way..."
        print("The class documentation is: " + Movie.__doc__)

    def name(): #prints the class name: Movie
        print("The class name is: " + Movie.__name__)

    def mod(): #prints the module name: movieWebsite_media
        print("The module name is: " + Movie.__module__)
