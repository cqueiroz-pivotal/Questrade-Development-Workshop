using OrderService.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace OrderService
{
    public interface IOrderRespository
    {
        IEnumerable<Order> GetOrders();
        Order GetOrderByID(int orderId);
        void InsertOrder(Order order);
        void DeleteOrder(int orderID);
        void UpdateOrder(Order order);
        void Save();
    }
}