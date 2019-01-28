using csharp.dto;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using IniParser;
using IniParser.Model;

namespace csharp
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {

        IniData data = new FileIniDataParser().ReadFile("config/main.ini");
        public MainWindow()
        {
            InitializeComponent();
            var parser = new FileIniDataParser();
           
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
           Login(username.Text, password.Password);

        }

        private async void Login(String username, String password) {
            HttpClient httpClient = new HttpClient();
            string body = await httpClient.GetStringAsync(data.GetKey("server") + "/api/v1/login?username=" + username + "&password=" + password);
            Response<String> rep = JsonConvert.DeserializeObject<Response<String>>(body);
            if (rep.code == 0)
            {
                new System.IO.DirectoryInfo(data.GetKey("cache_dir") +"/" + rep.body).Create();
                new System.IO.DirectoryInfo(data.GetKey("data_dir")+"/" + rep.body).Create();
                new System.IO.DirectoryInfo(data.GetKey("log_dir")+"/" + rep.body).Create();
                Workspace workspace = new Workspace();
                workspace.Show();
                this.Hide();
            }
            else {
                MessageBox.Show(rep.msg);
            }
     
        }
    }
}
