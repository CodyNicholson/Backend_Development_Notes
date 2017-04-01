# .NET Framework Overview

Microsoft Visual C# is a managed language that is **part of the Microsoft .NET Framework**

When writing C# applications, it is important to understand how your application code behaves
on the computer

-

Your application executes on the target computing platform through the use of the **Common Language
Runtime (CLR)**

This also means that **C# is a Just-in-Time (JIT) compiled language**

The **common language runtime** is the foundation of the .NET Framework

The runtime is responsible for managing your code at execution time

It provides core services such as memory management, thread management, and remoting

The CLR enforces strict type safety and provides security and robustness for managed applications

-

The **class library** is a comprehensive collection of reusable types, .NET classes, that you will use to develop applications ranging from traditional command-line or graphical user interface (GUI) applications to applications based on the latest innovations provided by ASP.NET and Microsoft Azure services

The .NET Framework and C# are extensible and also allow you to easily create your own custom classes and libraries of managed objects for code reuse

-

Code that **targets the runtime** is known as **managed code**, while code that **does not target the runtime** is known as **unmanaged code**

The .NET Framework can be hosted by unmanaged components that load the common language runtime into their processes and initiate the execution of managed code, thereby creating a software environment that can exploit both managed and unmanaged features

The .NET Framework not only provides several runtime hosts, but also supports the development of third-party runtime hosts

For example, ASP.NET hosts the runtime to provide a scalable, server-side environment for managed code

ASP.NET works directly with the runtime to enable ASP.NET applications and XML Web services, both of which are discussed later in this topic

All of these components coexist and interact to provide a platform for your C# application
