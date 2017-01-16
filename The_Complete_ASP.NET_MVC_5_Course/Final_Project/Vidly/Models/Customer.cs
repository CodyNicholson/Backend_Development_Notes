using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Vidly.Models
{
    public class Customer
    {
        public int Id { get; set; }
        [Required] // Name is not nullable anymore, it is now required
        [StringLength(255)] // Name is not unlimited characters anymore, it is 255
        public string Name { get; set; }
        public bool IsSubscribedToNewsletter { get; set; }
        public MembershipType MembershipType { get; set; } //Navigation Property
        public byte MembershipTypeId { get; set; }
        public DateTime? Birthdate { get; set; }
    }
}