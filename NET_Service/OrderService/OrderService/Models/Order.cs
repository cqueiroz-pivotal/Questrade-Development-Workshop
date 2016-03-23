using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace OrderService.Models
{
    public class Order
    {
        public int ID { get; set; }
        public long customerId { get; set; }
        public int quantity { get; set; }
    }
}