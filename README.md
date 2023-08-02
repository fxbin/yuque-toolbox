# yuque-toolbox

## 用途描述

> 便于个人导出备份， 同时提供Java版本 yuque-sdk 

## 环境&版本
* spring-boot 3.1.2
* forest 1.5.32

## 模块
* yuque-export
* yuque-sdk

## 用法
```yaml
yuque:
  # 默认值即为 ： https://www.yuque.com/api/v2
  base-url: https://www.yuque.com/api/v2
  token: token
  export:
    path: /data
```

## 语雀文档

[开发者文档](https://www.yuque.com/yuque/developer)