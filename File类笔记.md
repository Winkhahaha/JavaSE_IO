

###19.14_File类(File类的概述和构造方法)
* A:File类的概述
  * File更应该叫做一个路径
    * 文件路径或者文件夹路径  
    * 路径分为绝对路径和相对路径
    * 绝对路径是一个固定的路径,从盘符开始
    * 相对路径相对于某个位置,在eclipse下是指当前项目下,在dos下
  * 查看API指的是当前路径
  * 文件和目录路径名的抽象表示形式
* B:构造方法
  * File(String pathname)：根据一个路径得到File对象
  * File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
  * File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
* C:案例演示
  * File类的构造方法

###19.15_File类(File类的创建功能)
* A:创建功能
  * public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
  * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
  * public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
* B:案例演示
  * File类的创建功能

  * 注意事项：
    * 如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。

###19.16_File类(File类的重命名和删除功能)
* A:重命名和删除功能
  * public boolean renameTo(File dest):把文件重命名为指定的文件路径
  * public boolean delete():删除文件或者文件夹
* B:重命名注意事项
  * 如果路径名相同，就是改名。
  * 如果路径名不同，就是改名并剪切。
* C:删除注意事项：
  * Java中的删除不走回收站。
  * 要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹


###19.17_File类(File类的判断功能)
* A:判断功能
  * public boolean isDirectory():判断是否是目录
  * public boolean isFile():判断是否是文件
  * public boolean exists():判断是否存在
  * public boolean canRead():判断是否可读
  * public boolean canWrite():判断是否可写
  * public boolean isHidden():判断是否隐藏
* B:案例演示
  * File类的判断功能

###19.18_File类(File类的获取功能)
* A:获取功能
  * public String getAbsolutePath()：获取绝对路径
  * public String getPath():获取路径
  * public String getName():获取名称
  * public long length():获取长度。字节数
  * public long lastModified():获取最后一次的修改时间，毫秒值
  * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
  * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组 
* B:案例演示
  * File类的获取功能

###19.19_File类(输出指定目录下指定后缀的文件名)
* A:案例演示
  * 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称

###19.20_File类(文件名称过滤器的概述及使用)
* A:文件名称过滤器的概述
  * public String[] list(FilenameFilter filter)
  * public File[] listFiles(FileFilter filter)
* B:文件名称过滤器的使用
  * 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
* C:源码分析
  * 带文件名称过滤器的list()方法的源码

###19.21_File类(递归)
* 5的阶乘		

###19.22_day19总结
把今天的知识点总结一遍。