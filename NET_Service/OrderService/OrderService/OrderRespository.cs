using OrderService.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace OrderService
{
    public class OrderRespository : IOrderRespository
    {
        OrderContext context = new OrderContext();
      
        public IEnumerable<Order> GetOrders()
        {
            return context.Orders;
        }

        public Order GetOrderByID(int orderId)
        {
            var o = (from r in context.Orders where r.ID == orderId select r).FirstOrDefault();
            return o;
        }

        public void InsertOrder(Order order)
        {
            context.Orders.Add(order);
            Save();
        }

        public void DeleteOrder(int orderID)
        {
            Order o = context.Orders.Find(orderID);
            context.Orders.Remove(o);
            context.SaveChanges();
        }

        public void UpdateOrder(Order order)
        {
            context.Entry(order).State = System.Data.Entity.EntityState.Modified;
        }

        public void Save()
        {
            context.SaveChanges();
        }

    }
    
}