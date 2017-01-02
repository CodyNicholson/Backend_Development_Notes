using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Vidly.Models;
using Vidly.ViewModels;

namespace Vidly.Controllers
{
    public class MoviesController : Controller
    {
        // GET: Movies/Random
        public ActionResult Random()
        {
            var movie = new Movie() { Name = "Shrek!" };
            var customers = new List<Customer>
            {
                new Customer { Name = "Customer 1" },
                new Customer { Name = "Customer 2" }
            };

            var viewModel = new RandomMovieViewModel
            {
                Movie = movie,
                Customers = customers
            };

            return View(viewModel);

            //return content("hello"); // sends plain string content to the application
            //return httpnotfound(); // sends an http not found error to application
            //return new emptyresult(); // sends a blank webpage to application
            //return redirecttoaction("index", "home", new { page = 1, sortby = "name" }); // redirects the user to the home page and sends the page and sortby variables to the url
        }

        public ActionResult RandomViewBag()
        {
            // This is just to show you there are other way to send data to the view
            // DO NOT USE VIEW DATA OR VIEW BAG, just pass data through the View()
            var movie = new Movie() { Name = "Shrek!" };

            ViewData["RandomMovie"] = movie; // Requires that you modify Random.cshtml
            ViewBag.Movie = movie; // Requires that you modify Random.cshtml

            return View(movie);
        }

        public ActionResult Edit(int id)
        {
            return Content("id="+id);
        }

        // int? means that this int parameter it nullable
        public ActionResult Index(int? pageIndex, string sortBy)
        {
            if (!pageIndex.HasValue)
                pageIndex = 1;
            if (String.IsNullOrWhiteSpace(sortBy))
                sortBy = "Name";
            return Content(String.Format("pageIndex={0}&sortBy={1}", pageIndex, sortBy));

        }

        [Route("movies/released/{year:regex(\\d{4})}/{month:regex(\\d{2}):range(1,12)}")]
        public ActionResult ByReleaseDate(int year, int month)
        {
            return Content(year + "/" + month);
        }
    }
}