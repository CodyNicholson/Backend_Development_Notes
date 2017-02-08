#Data Transfer Objects (DTOs)

When we built our API, we gave access to our User objects to anyone

This is dangerous because anyone can update the information in the User object

-

To solve this problem we can Use a DTO to exclude the properties of our model that can be updated

This is the code for our Customer model:

```cs
namespace Vidly.Models
{
    public class Customer
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Please enter a valid Customer Name")] // Name is not nullable anymore, it is now required
        [StringLength(255)] // Name is not unlimited characters anymore, it is 255
        public string Name { get; set; }

        public bool IsSubscribedToNewsletter { get; set; }

        public MembershipType MembershipType { get; set; } //Navigation Property

        [Display(Name = "Membership Type")]
        public byte MembershipTypeId { get; set; }

        [Display(Name = "Date of Birth")] // Will display in the view as "Date of Birth" instead of "Birthdate"
        [Min18YearsIfAMember]
        public DateTime? Birthdate { get; set; }

        public static readonly byte Unknown = 0;
        public static readonly byte PayAsYouGo = 1;
    }
}
```

The DTO for this model would look this this:

```cs
namespace Vidly.DTOs
{
    public class CustomerDto
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Please enter a valid Customer Name")] // Name is not nullable anymore, it is now required
        [StringLength(255)] // Name is not unlimited characters anymore, it is 255
        public string Name { get; set; }

        public bool IsSubscribedToNewsletter { get; set; }

        public byte MembershipTypeId { get; set; }

        [Min18YearsIfAMember]
        public DateTime? Birthdate { get; set; }
    }
}
```

Notice that we did not include the MembershipType property here. That is because - since the membershipType has its own model - it gets its own DTO, but that is not needed for this situation.

Also notice that we don't include and of the Display name data annotations because they are already defined in the Customer model, and are not needed here

***

###Auto Mapper

In the Customer controller, anywhere we return a customer object we need to map it to our DTO

We can do this using the **Auto Mapper**

-


