HAR
===

HAR file reader, writer and viewer.

`har` is a library for reading and writing HAR files directly. The need for building another
library arose from the fact that all other implementations use, `jackson` JSON parser, whereas
I needed to use Google `GSON` library for parsing. As a library it also includes many convenience
methods to working with the HAR model instance.

`har` is also a command line application that can be used to view the `HAR` files offline, either
on the console or inside the browser. Every other known tool currently requires you to either go
online, or install a browser extension or run a PHP (or another) server.

`har` is also a set of utilities that help in working with files, like extracting specific pages
or request, or viewing the response. 

Usage
-----

Reading a HAR file is as easy as:

```java
// via a file
Har har = HarUtils.read(new File("~/test.har"));

// via a string
har = HarUtils.read(" { .... HAR as string } ");

// via a reader
har = HarUtils.read(new FileReader(new File("~/test.har")));

// via a JsonElement
har = HarUtils.read(harJsonElement);
```

Changelog
---------

**Current Development**

Downloads
---------

The library can be downloaded from Maven Central using:

```xml
<dependency>
    <groupId>com.sangupta</groupId>
    <artifactId>har</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Versioning
----------

For transparency and insight into our release cycle, and for striving to maintain backward compatibility, 
`har` will be maintained under the Semantic Versioning guidelines as much as possible.

Releases will be numbered with the follow format:

	<major>.<minor>.<patch>

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

For more information on SemVer, please visit http://semver.org/.

License
-------
	
```
har - HAR file reader, writer and viewer
Copyright (c) 2014, Sandeep Gupta

	http://sangupta.com/projects/har

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
