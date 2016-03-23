using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.ServiceModel.Web;
using System.Web.Http;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;

namespace SimplePCFApplication.Controllers
{
    public class ContactController : ApiController
    {

        [WebMethod]
        public void Get(HttpContext context)
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
            context.Response.Write(js.Serialize(orders));
        }

       
    }



    public class Order
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}
