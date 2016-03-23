using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using System.Web.Script.Serialization;

namespace ProductServer.Controllers
{
    public class ProductController : ApiController
    {

        
        public void Get()
        {
            Order[] orders = new Order[] {
                new Order() {
                    Id=1,
                    Name="Luke"
                },
                new Order() {
                    Id=2,
                    Name="Dan"
                }
            };
            JavaScriptSerializer js = new JavaScriptSerializer();
            HttpContext.Current.Response.Write(js.Serialize(orders));
        }
    }
}
