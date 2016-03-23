using OrderService.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace OrderService.Controllers
{

  
    public class OrderController : ApiController
    {

        OrderRespository repo = new OrderRespository();

        // GET api/values
        public IEnumerable<Order> Get()
        {
            return repo.GetOrders();
            //return new Order[] {
            //    new Order{ customerId="1",  ID = 1, quantity = 10 },
            //    new Order{ customerId="2",  ID = 3, quantity = 20 }
            //};
        }

        // GET api/values/5
        public Order Get(int id)
        {
            return repo.GetOrderByID(id);
        }

        // POST api/values
        public void Post([FromBody]Order value)
        {
            //todo: probably need to check if this and update vs insert
            repo.InsertOrder(value);
        }

        // PUT api/values/5
        public void Put(int id, [FromBody]Order value)
        {
            repo.UpdateOrder(value);
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
            repo.DeleteOrder(id);
        }

    }
}