using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace csharp
{
    /// <summary>
    /// App.xaml 的交互逻辑
    /// </summary>
    public partial class App : Application
    {

        protected override void OnActivated(EventArgs e)
        {
            base.OnActivated(e);
        }

        protected override void OnDeactivated(EventArgs e)
        {
            base.OnDeactivated(e);
        }

        protected override void OnExit(ExitEventArgs e)
        {
            base.OnExit(e);
            MessageBox.Show("Exit");
        }

        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            //判断用户登录 启动登录窗口还是 工作窗口
            Workspace workspace = new Workspace();
            workspace.Show();
        }
    }
}
