using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Mvc;

namespace SimplePCFApplication.Controllers
{
    public class ContactController : ApiController
    {
        public ContentResult Get()
        {
            ContentResult result = new ContentResult();
            result.ContentType = "application/json";
            result.Content = "Test";
            return result;
        }

    }
}
