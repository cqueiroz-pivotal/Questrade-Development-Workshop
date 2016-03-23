using OrderService.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace OrderService
{
    public class OrderContext : DbContext
    {
        public OrderContext() : base("name=OrderDBConnectionString")
        {
        }

        public DbSet<Order> Orders { get; set; }
    }
}