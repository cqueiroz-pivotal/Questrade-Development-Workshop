using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace OrderService
{
    /**
     * This class is used to actually get the connection details from VCAPS otherwise look it up in Web.config
     * */
    public class CloudSqlConnection
    {
        private static String actualConnection = String.Empty;

        public static String ConnectionString
        {
            get
            {
                if (actualConnection == String.Empty)
                {
                    loadConnectionString();
                }
                return actualConnection;
            }
        }

        private static void loadConnectionString()
        {
            //if running outside PCF this will be NULL
            if (Environment.GetEnvironmentVariable("VCAP_SERVICES") != null)
            {
                Dictionary<string, object> vcapServices = Newtonsoft.Json.JsonConvert.DeserializeObject<Dictionary<string, object>>( 
                    Environment.GetEnvironmentVariable("VCAP_SERVICES"));
               
                if (vcapServices != null)
                {
                     // this is the dumb way - this is the smart way https://github.com/dmikusa-pivotal/cf-ex-phpmyadmin/blob/master/htdocs/config.inc.php
                    var credentials = ((Newtonsoft.Json.Linq.JArray)vcapServices["p-mysql"]).First()["credentials"];
                    if (credentials != null)
                    {
                        //this is what the connection string looks like : Server=localhost;Database=OrderDB;Uid=root;Pwd=password;
                        actualConnection = "Server =" + credentials["hostname"] + "; Port =" + credentials["port"] + ";  Database = OrderDB; Uid =" + credentials["username"] + "; Pwd =" + credentials["password"] + ";"; 
                    }
                }
            }
            //look in Web.conf otherwise
            else
            {
                actualConnection = "name=OrderDBConnectionString";
            }

                    
        }
    }
}