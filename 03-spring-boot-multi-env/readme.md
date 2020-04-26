* 本地构建

```shell script
mvn clean install -Dmaven.test.skip=true -Dprofiles.active={配置环境} -U -e [自定义配置项]

mvn clean install -Dmaven.test.skip=true -Dprofiles.active=dev -U -e -Dapi.url=127.0.0.1:12645
mvn clean install -Dmaven.test.skip=true -Dprofiles.active=test -U -e -Dapi.url=127.0.0.1:12645
mvn clean install -Dmaven.test.skip=true -Dprofiles.active=pre -U -e -Dapi.url=127.0.0.1:12645
mvn clean install -Dmaven.test.skip=true -Dprofiles.active=prod -U -e -Dapi.url=127.0.0.1:12645
```
* 远程发布

```shell script
mvn clean deploy -Dmaven.test.skip=true -Dprofiles.active={配置环境} -Dpvervion={版本号} -U -e [自定义配置项]

mvn clean deploy -Dmaven.test.skip=true -Dprofiles.active=dev -Dpvervion=0.0.2-SNAPSHOT-DEV -U -e -Dapi.url=127.0.0.1:12645
mvn clean deploy -Dmaven.test.skip=true -Dprofiles.active=test -Dpvervion=0.0.3-SNAPSHOT-TEST -U -e -Dapi.url=127.0.0.1:12645
mvn clean deploy -Dmaven.test.skip=true -Dprofiles.active=pre -Dpvervion=0.0.4-SNAPSHOT-PRE -U -e -Dapi.url=127.0.0.1:12645
mvn clean deploy -Dmaven.test.skip=true -Dprofiles.active=prod -Dpvervion=1.0.1.20200102-release -U -e -Dapi.url=127.0.0.1:12645
```

### mvn命令可选参数说明：
在持续集成服务器上使用怎样的 mvn 命令集成项目，这个问题乍一看答案很显然，不就是 mvn clean install 么？事实上比较好的集成命令会稍微复杂些，下面是一些总结：

1. 不要忘了clean： clean能够保证上一次构建的输出不会影响到本次构建。
2. 使用deploy而不是install： 构建的SNAPSHOT输出应当被自动部署到私有Maven仓库供他人使用，这一点在前面已经详细论述。
3. 使用-U参数： 该参数能强制让Maven检查所有SNAPSHOT依赖更新，确保集成基于最新的状态，如果没有该参数，Maven默认以天为单位检查更新，而持续集成的频率应该比这高很多。
4. 使用-e参数：如果构建出现异常，该参数能让Maven打印完整的stack trace，以方便分析错误原因。
5. 使用-Dmaven.repo.local参数：如果持续集成服务器有很多任务，每个任务都会使用本地仓库，下载依赖至本地仓库，为了避免这种多线程使用本地仓库可能会引起的冲突，可以使用-Dmaven.repo.local=/home/juven/ci/foo-repo/这样的参数为每个任务分配本地仓库。
6. 使用-B参数：该参数表示让Maven使用批处理模式构建项目，能够避免一些需要人工参与交互而造成的挂起状态。

综上，持续集成服务器上的集成命令应该为 mvn clean deploy -B -e -U -Dmaven.repo.local=xxx 。此外，定期清理持续集成服务器的本地Maven仓库也是个很好的习惯，这样可以避免浪费磁盘资源，几乎所有的持续集成服务器软件都支持本地的脚本任务，你可以写一行简单的shell或bat脚本，然后配置以天为单位自动清理仓库。需要注意的是，这么做的前提是你有私有Maven仓库，否则每次都从Internet下载所有依赖会是一场噩梦。