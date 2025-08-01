# 📚 Hibernate Full Syllabus (Lecture-Wise)

## Module 1: Introduction to ORM and Hibernate
	Lecture 1: What is ORM (Object Relational Mapping)?
	
	Lecture 2: Introduction to Hibernate
	
	Lecture 3: Hibernate Architecture and Workflow

## Module 2: Hibernate Setup and Configuration
	Lecture 4: Setting Up Hibernate Project (with Maven)
	
	Lecture 5: Hibernate Configuration (hibernate.cfg.xml and annotations)
	
	Lecture 6: Creating First Hibernate Application (Hello World)

## Module 3: Hibernate Core Concepts
	Lecture 7: Hibernate Annotations vs XML Configuration
	
	Lecture 8: Hibernate Mapping (One-to-One, One-to-Many, Many-to-One, Many-to-Many)
	
	Lecture 9: Primary Key Generation Strategies

## Module 4: CRUD Operations
	Lecture 10: Create Operation (Saving Objects)
	
	Lecture 11: Read Operation (Fetching Data)
	
	Lecture 12: Update and Delete Operations

## Module 5: Advanced Hibernate Features
	Lecture 13: Hibernate Query Language (HQL)
	
	Lecture 14: Criteria API
	
	Lecture 15: Named Queries and Native SQL

## Module 6: Hibernate Transactions and Caching
	Lecture 16: Hibernate Transaction Management
	
	Lecture 17: Hibernate Caching (First Level and Second Level Cache)

## Module 7: Relationships and Cascading
	Lecture 18: Cascade Types and Fetch Strategies
	
	Lecture 19: Bidirectional Mapping and Inverse Keyword

## Module 8: Hibernate with Real Databases
	Lecture 20: Connecting to MySQL or PostgreSQL
	
	Lecture 21: Handling Large Data (LOBs: Clob and Blob)

## Module 9: Hibernate Integration
	Lecture 22: Hibernate with JSP/Servlet
	
	Lecture 23: Hibernate with Spring (Basics)

## Module 10: Interview Questions and Practice
	Lecture 24: Hibernate Interview Questions and Answers
	
	Lecture 25: Practice Assignment and Mini Project
	
# Module 1: Introduction to ORM and Hibernate
## Lecture 1: What is ORM (Object Relational Mapping)?
	 🔷 1. What is ORM?
			-- ORM stands for Object Relational Mapping.
			
			-- It is a programming technique that maps Java objects (classes, fields) to relational database tables (rows, columns).
			
	🔷 2. Why Use ORM?
			-- Traditional JDBC:
			
					- Needs you to write SQL manually
				
					- You manage ResultSets, connections, type conversions
				
					- Code is long and error-prone
			
			-- ORM handles all that:
			
					- Converts Java object to SQL automatically
			
					- Maps result from SQL back to Java objects

					- Manages connections and transactions for you
					
	🔷 3. Benefits of ORM
			--	| Feature              | Description                                            |
				|----------------------|------------------------------------------------------- |
				| 🔄 Automatic Mapping | Maps Java classes to DB tables                         |
				| ✅ Easy CRUD         | Perform insert, update, delete with simple Java code   |
				| 💡 Cleaner Code      | No need to write SQL manually                          |
				| 💾 DB Independent    | Works with MySQL, Oracle, PostgreSQL, etc.             |
				| ⚡ Fast Development  | Focus on objects, not SQL                              |
				| 🧠 Caching           | Hibernate uses cache to improve performance            |
				
	🔷 4. How ORM Works
				-- Internally, ORM:
						-- Reads your Java class and annotations (or XML)
				
						-- Builds mapping to DB tables
						
						-- Converts Java method calls to SQL commands
						
						-- Executes SQL using JDBC behind the scenes
				
						-- Converts DB results back to Java objects
						
	🔷 5. Types of ORM Mapping Strategies
				-- Strategy										Description
					✅ Table per Class							One class = One table
					✅ Table per Subclass						Inheritance: subclass gets its own table
					✅ Table per Hierarchy						Entire class hierarchy in one table (with a type column)
					
	🔷 6. Java ORM Tools
			--	ORM Tool											Description
				Hibernate											Most popular ORM in Java
				JPA													Specification (Hibernate implements it)
				MyBatis											Semi-ORM (you still write SQL manually)
				EclipseLink										JPA implementation by Eclipse
				TopLink											Oracle’s ORM (older, less used now)
				
## 	Lecture 2: Introduction to Hibernate
	🔷 1. What is Hibernate?
			--	Hibernate is a Java-based ORM (Object Relational Mapping) framework that:
				
				Automates the mapping between Java objects (POJOs) and relational database tables.
				
			--	It allows developers to interact with the database using Java code instead of manual SQL.
	
	🔷 2. Who Developed Hibernate?
			-- Developed by Gavin King
			
			-- Initially released in 2001
			
			-- Now maintained under JBoss (Red Hat)
			
	🔷 3. Why Use Hibernate?
			-- Problem in JDBC									Hibernate Solution
			Manual SQL writing									Automatic query generation (HQL/Criteria)
			Manual result mapping								Object mapping done automatically
			No caching											Built-in caching
			Verbose boilerplate code							Clean and short code
			Tight DB dependency								DB-independent via dialects	
			
	🔷 4. Hibernate vs JDBC
			--	Feature						JDBC									Hibernate
			SQL Writing						Manual									Auto-generated or HQL
			Object Mapping					Manual									Automatic via annotations/XML
			Caching							No										Yes (1st & 2nd level)
			Transactions						Manual									Built-in support
			Performance						Depends on developer				Optimized internally
			
	🔷 5. Hibernate Key Features
			--	Feature											Description
				✅ ORM Support									Maps Java POJOs to DB tables
				📝 HQL												Hibernate Query Language (object-based SQL)
				💾 Caching										Improves performance by reducing DB hits
				🔄 Lazy Loading									Loads data only when needed
				🔗 Relationship Mapping						One-to-One, One-to-Many, etc.
				⚙️ Configurable									Via XML or Annotations
				🧶 DB Independence								Supports many DBs via Dialects
				
	🔷 6. Technologies Hibernate Supports
			--	Area												Support
				DB Support										MySQL, PostgreSQL, Oracle, etc.
				Mapping Style									XML or Annotations
				APIs												HQL, Criteria, Native SQL
				Caching											EhCache, Infinispan, etc.
				Framework Integration							Spring, JSP/Servlet, etc.
				
	🔷 7. Hibernate Architecture (Overview)


											Java App
											   ↓
						SessionFactory → Session → Transaction
											   ↓
											  JDBC
											   ↓
											Database
											
## 🧠 What is a POJO in Java?
				✅ POJO stands for:
					-- Plain Old Java Object
				
				-- 	It refers to a simple Java class that doesn’t extend, implement, or depend on any 					special libraries or frameworks — it’s just a basic object with:
				
						- Private fields
						
						- Public getters/setters
						
						- No business logic or framework-specific code
						
						✅ Summary
						--	Term									Description
							POJO									Plain Old Java Object
							Used in								Hibernate, Spring, JPA, REST APIs
							Purpose								To represent entities (tables)
							Benefits								Simple, clean, decoupled from frameworks
							
## Lecture 3: Hibernate Architecture and Workflow

	🔷 1. Hibernate Architecture Diagram (Conceptual)

									 	 +-------------------------+
									    |      Application        |
									    +-----------+-------------+
									                |
									                v
									    +-----------+-------------+
									    |      Hibernate API      | ← (Session, SessionFactory, Query, etc.)
									    +-----------+-------------+
									                |
									                v
									    +-----------+-------------+
									    |  Hibernate Core Engine  |
									    |  (Configuration, ORM,   |
									    |   Transaction Mgmt, etc)|
									    +-----------+-------------+
									                |
									                v
									    +-----------+-------------+
									    |     JDBC (Database API) |
									    +-----------+-------------+
									                |
									                v
									    +-----------+-------------+
									    |       Database          |
									    +-------------------------+
									    
	🔷 2. Key Components in Hibernate Architecture

				| Component        | Description                                                        				|
				| ---------------- | ------------------------------------------------------------------|
				| `Configuration`  | Loads Hibernate settings from `hibernate.cfg.xml` or `.properties` |
				| `SessionFactory` | A factory for `Session` objects; heavy object, created once        |
				| `Session`        | Represents a single unit of work (one DB interaction session)      |
				| `Transaction`    | Handles commit/rollback of database operations                     |
				| `Query/Criteria` | For writing HQL or criteria-based queries                          |
				| `JDBC`           | Hibernate internally uses JDBC to connect with DB                  |
				| `Database`       | The actual data source like MySQL, Oracle, etc.                    |
				
				
	🔷 3. Workflow of Hibernate
					Let's break down the typical flow when using Hibernate:
					
					📌 Step-by-step:
				1.	Configuration Setup
					Load settings from hibernate.cfg.xml file (DB connection, dialect, mapping info).
					
				2.	Create SessionFactory
					This is a one-time creation during app startup. It's like a heavyweight object.
					
				3.	Open Session
					Session is created from SessionFactory. It's a lightweight object.
					
				4.	Begin Transaction
					Start a transaction using session.beginTransaction().
					
				5.	Perform DB Operations
					Use methods like save(), update(), delete(), or execute HQL/SQL queries.
					
				6.	Commit or Rollback
					Finish the transaction with commit() or rollback() on failure.
					
				7.	Close Session
					Close the session using session.close() to release JDBC resources.
					
	🔷 4. Example Code (Basic Flow)
					Configuration cfg = new Configuration();
					cfg.configure("hibernate.cfg.xml");
					
					SessionFactory factory = cfg.buildSessionFactory();
					Session session = factory.openSession();
					
					Transaction tx = session.beginTransaction();
					
					Employee emp = new Employee();
					emp.setName("John");
					emp.setSalary(5000);
					
					session.save(emp);  // Insert
					
					tx.commit();        // Commit to DB
					session.close();    // Release resources
		
	
	🔷 5. Summary
				-- Hibernate architecture sits between Java app and database.
				
				-- The SessionFactory is key to managing DB sessions efficiently.
				
				-- Hibernate abstracts away JDBC complexities.
				
				-- It supports automatic transaction management, caching, and object-relational mapping.

	
# Module 2: Hibernate Setup and Configuration
## Lecture 4: Setting Up Hibernate Project (with Maven)

	🔷 2. Create Maven Project (in IDE or manually)
				-- If you're using Eclipse or IntelliJ:
				
				-- Go to File → New → Maven Project
				
				-- Choose Quickstart or create from scratch
				
			If you're using CLI:
			mvn archetype:generate -DgroupId=com.hibernate -DartifactId=HibernateApp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
			
	🔷 3. Maven pom.xml Configuration
			Add these Hibernate dependencies in your pom.xml file:
			
					<!-- Hibernate Core -->
					  	<dependency>
						    <groupId>org.hibernate.orm</groupId>
						    <artifactId>hibernate-core</artifactId>
						    <version>6.5.2.Final</version>
						</dependency>
					
					   <!-- JPA API (optional but recommended) -->
						<dependency>
						    <groupId>jakarta.persistence</groupId>
						    <artifactId>jakarta.persistence-api</artifactId>
						    <version>3.2.0</version>
						</dependency>
						
						<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
						<!-- MySQL JDBC Driver -->
						<dependency>
						    <groupId>mysql</groupId>
						    <artifactId>mysql-connector-java</artifactId>
						    <version>8.0.28</version>
						</dependency>
				
						<!-- Logging dependencies (optional but useful) -->
				 		<dependency>
				            <groupId>org.jboss.logging</groupId>
				            <artifactId>jboss-logging</artifactId>
				            <version>3.4.3.Final</version>
				       </dependency>
				       
				       
	
	🔷 4. Project Structure
					Here’s what your folder structure should look like:
				
					HibernateApp/
					├── src/
					│   ├── main/
					│   │   ├── java/
					│   │   │   └── com/hibernate/entity/Employee.java
					│   │   │   └── com/hibernate/MainApp.java
					│   │   └── resources/
					│   │       └── hibernate.cfg.xml
					├── pom.xml
					
					
	🔷 5. Hibernate Configuration File (hibernate.cfg.xml)
					Place this file in: src/main/resources/hibernate.cfg.xml
					
					<?xml version="1.0" encoding="UTF-8"?>
					<hibernate-configuration>
					    <session-factory>
					
					        <!-- Database connection settings -->
					        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
					        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/database-name</property>
					        <property name="hibernate.connection.username">root</property>
					        <property name="hibernate.connection.password">password</property>
					
					        <!-- SQL dialect -->
					        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
					
					        <!-- Echo SQL to console -->
					        <property name="hibernate.show_sql">true</property>
					        <property name="hibernate.format_sql">true</property>
					
					        <!-- Automatically create/update schema -->
					        <property name="hibernate.hbm2ddl.auto">update</property>
					
					      
					    </session-factory>
					</hibernate-configuration>
					
					
	🔷 6. Create a Sample Entity Class
		📁 File: src/main/java/com/hibernate/entity/Employee.java
				
				package com.hibernate.entity;
				import jakarta.persistence.*;
				
				@Entity
				@Table(name = "employees")
				public class Employee { 
				    @Id
				    @GeneratedValue(strategy = GenerationType.IDENTITY)
				    private int id;
				    private String name;
				    private double salary;
				
				    // Getters and setters
				    public int getId() { return id; }
				    public void setId(int id) { this.id = id; }
				
				    public String getName() { return name; }
				    public void setName(String name) { this.name = name; }
				
				    public double getSalary() { return salary; }
				    public void setSalary(double salary) { this.salary = salary; }
				}
				
	🔷 7. Create Main App to Test Setup
			📁 File: src/main/java/com/hibernate/MainApp.java
			
					package com.hibernate;
					import org.hibernate.Session;
					import org.hibernate.SessionFactory;
					import org.hibernate.Transaction;
					import org.hibernate.cfg.Configuration;
					import com.hibernate.entity.Employee;
					
					public class MainApp {
					    public static void main(String[] args) {
					        Configuration cfg = new Configuration().configure();
					        cfg.configure("hibernate.cfg.xml");
    							cfg.addAnnotatedClass(employees.class);
					        SessionFactory factory = cfg.buildSessionFactory();
					        Session session = factory.openSession();
					
					        Transaction tx = session.beginTransaction();
					
					        Employee emp = new Employee();
					        emp.setName("Shamsher");
					        emp.setSalary(75000);
					
					        session.save(emp);
					        tx.commit();
					        session.close();
					
					        System.out.println("Data saved successfully.");
					    }
					}
					
## Lecture 5: Hibernate Configuration (hibernate.cfg.xml and annotations)
		 There are two essential ways to configure Hibernate:
		 
			-- Using the hibernate.cfg.xml file (XML-based configuration)

			-- Using Annotations (Java-based configuration inside Entity classes)
			
		🔷 1. XML-Based Configuration: hibernate.cfg.xml
		
			This is the traditional and most widely used method to configure Hibernate.
			
			📁 Location:
			Place this file inside: src/main/resources/hibernate.cfg.xml
			
					 <?xml version='1.0' encoding='utf-8'?>

					<hibernate-configuration>
					  <session-factory>
					
					    <!-- DB connection properties -->
					    <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
					    <property name="connection.url">jdbc:mysql://localhost:3306/hibernatedb</property>
					    <property name="connection.username">root</property>
					    <property name="connection.password">yourpassword</property>
					
					    <!-- JDBC connection pool -->
					    <property name="connection.pool_size">1</property>
					
					    <!-- SQL dialect -->
					    <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
					
					    <!-- Show SQL in console -->
					    <property name="show_sql">true</property>
					
					    <!-- Schema auto update -->
					    <property name="hbm2ddl.auto">update</property>
					
					    <!-- Register entity class -->
					    <mapping class="com.hibernate.entity.Employee"/>
					
					  </session-factory>
					</hibernate-configuration>
					
	🔷 2. Annotation-Based Configuration
			Hibernate supports JPA Annotations, which makes configuration cleaner and object-oriented.
				
	📁 Employee.java
				package com.hibernate.entity;
				import jakarta.persistence.*;	
					@Entity
					@Table(name = "employees")
					public class Employee {
					
					    @Id
					    @GeneratedValue(strategy = GenerationType.IDENTITY)
					    private int id;
					
					    private String name;
					    private double salary;
					
					    // Getters and setters
					}
				

					
	🔷 3. Common Hibernate Annotations
					Annotation	                Purpose
                    @Entity	                     Declares this class is a Hibernate Entity
                    @Table(name="...")	         Maps class to DB table
                    @Id	                         Marks the primary key field
                    @GeneratedValue(...)	     Tells Hibernate to auto-generate primary keys
                    @Column(name="...")	         Maps field to specific column name
                    @Transient	                 Excludes field from being persisted in DB	
                    
         
                    
	🔷 4. Combining Annotations with XML
			-- Even though you use annotations in entity classes, you still need hibernate.cfg.xml to define:

				1.DB connection

				2.Hibernate dialect

				3.SessionFactory setup

				4.Entity class registration (<mapping class="..."/>)

				5.Or you can skip <mapping class=.../> if you're using addAnnotatedClass() in code:
				
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				cfg.addAnnotatedClass(Employee.class); // optional if defined in XML
				
	🔷 5. Summary
		-- hibernate.cfg.xml is required for global setup (DB, dialect, show_sql, etc.)

		-- Entity classes use annotations like @Entity, @Id, etc.

		-- You can register entity classes in XML or programmatically using addAnnotatedClass()

		-- Annotations make Hibernate more Java-centric, avoiding extra XML mapping files
		
		
## Lecture 6: Creating First Hibernate Application (Hello World)

	🔷 1. Project Structure
					Your folder layout should look like this:
					
					bash
					Copy
					Edit
					HibernateHelloWorld/
					├── src/
					│   ├── main/
					│   │   ├── java/
					│   │   │   └── com/hibernate/entity/Employee.java
					│   │   │   └── com/hibernate/MainApp.java
					│   │   └── resources/
					│   │       └── hibernate.cfg.xml
					├── pom.xml
					
	🔷 2. pom.xml – Add Hibernate and MySQL Dependencies

					<dependencies>
					    <!-- Hibernate Core -->
				    <dependency>
				        <groupId>org.hibernate</groupId>
				        <artifactId>hibernate-core</artifactId>
				        <version>5.6.15.Final</version>
				    </dependency>
				
				    <!-- MySQL JDBC Driver -->
				    <dependency>
				        <groupId>mysql</groupId>
				        <artifactId>mysql-connector-j</artifactId>
				        <version>8.0.33</version>
				    </dependency>
				
				    <!-- JPA API -->
				    <dependency>
				        <groupId>jakarta.persistence</groupId>
				        <artifactId>jakarta.persistence-api</artifactId>
				        <version>3.1.0</version>
				    </dependency>
				</dependencies>
	🔷 3. Create the Entity Class
		📁 Employee.java
		t
	🔷 4. Create hibernate.cfg.xml Configurationn
		📁 hibernate.cfg.xml in src/main/resources/
		
	🔷 5. Create the Main App Classs
		📁 MainApp.java		
		
# Module 3: Hibernate Core Concepts
## Lecture 7: Hibernate Annotations vs XML Configuration
	🔰 1. What Is Mapping in Hibernate?
			-- Mapping in Hibernate is the process of linking Java classes (POJOs) to database tables, and class fields to table columns. This tells Hibernate how to persist Java objects into relational tables.
				
			-- There are two main ways to define this mapping:
			
					1. Annotations (Java-based)
					
					2. XML configuration files (external file-based)
					
			-- 🟩 2. Annotation-Based Configuration
						Hibernate annotations are part of Java Persistence API (JPA) and are placed directly inside Java classes.	
						@Entity
						@Table(name = "employee")
						public class Employee {
					    @Id
					    @GeneratedValue(strategy = GenerationType.IDENTITY)
					    private int id;
					    @Column(name = "emp_name")
					    private String name;
					}
					
					📌 Common Annotations:
					| Annotation                      | Purpose                                 |
					| ------------------------------- | --------------------------------------- |
					| `@Entity`                       | Marks class as entity (mapped to table) |
					| `@Table`                        | Specifies table name                    |
					| `@Id`                           | Primary key                             |
					| `@GeneratedValue`               | Auto-generates primary key              |
					| `@Column`                       | Maps field to table column              |
					| `@OneToOne`, `@ManyToOne`, etc. | Relationship mappings                   |
					
			📌 Entity & Table Mapping Annotations
					| Annotation          | Description                                                      |
					| ------------------- | ---------------------------------------------------------------- |
					| `@Entity`           | Marks the class as a Hibernate/JPA entity (maps to a table).     |
					| `@Table(name = "")` | Specifies the table name. Optional if it matches the class name. |
					
			🔑 Primary Key Annotations
						| Annotation                        | Description                                               |
						| --------------------------------- | --------------------------------------------------------- |
						| `@Id`                             | Specifies the primary key of the entity.                  |
						| `@GeneratedValue(strategy = ...)` | Defines how the primary key is generated.                 |
						| `@SequenceGenerator`              | Defines a sequence generator (used with sequences in DB). |
						| `@TableGenerator`                 | Used for table-based primary key generation.              |
			📦 Column & Property Mapping Annotations
							| Annotation           | Description                                                                   |
							| -------------------- | ----------------------------------------------------------------------------- |
							| `@Column(name = "")` | Maps a field to a column in the table.                                        |
							| `@Transient`         | Field is not persisted in the database.                                       |
							| `@Temporal`          | Specifies the type of `java.util.Date` or `Calendar` (DATE, TIME, TIMESTAMP). |
							| `@Enumerated`        | Maps `enum` to string or ordinal in DB.                                       |
							| `@Lob`               | Used to store large data like CLOB/BLOB.                                      |
							| `@Basic`             | Marks a property as basic (default behavior).                                 |

			🔄 Relationship Mapping Annotations
								| Annotation    | Description                                                      |
								| ------------- | ---------------------------------------------------------------- |
							| `@OneToOne`   | One-to-one relationship.                                         |
							| `@OneToMany`  | One-to-many relationship.                                        |
							| `@ManyToOne`  | Many-to-one relationship.                                        |
							| `@ManyToMany` | Many-to-many relationship.                                       |
							| `@JoinColumn` | Specifies the foreign key column.                                |
							| `@JoinTable`  | Defines join table for many-to-many.                             |
							| `mappedBy`    | Used in bidirectional relationships to indicate the owning side. |
							| `cascade`     | Controls cascading operations (e.g. persist, remove).            |
							| `fetch`       | Defines fetch strategy (LAZY or EAGER).                          |


			📥 Embedded Objects Annotations
						| Annotation            | Description                                  |
						| --------------------- | -------------------------------------------- |
						| `@Embedded`           | Embeds another class (value type).           |
						| `@Embeddable`         | Marks a class to be embedded in entities.    |
						| `@AttributeOverrides` | Overrides attributes of the embedded object. |
						| `@AttributeOverride`  | Overrides a single attribute mapping.        |


			🧪 Validation & Versioning Annotations
						| Annotation              | Description                                        |
						| ----------------------- | -------------------------------------------------- |
						| `@Version`              | For optimistic locking. Adds a version column.     |
						| `@NotNull`              | Field must not be null. (From Bean Validation API) |
						| `@Size`, `@Min`, `@Max` | Size or range constraints.                         |
						| `@Pattern`              | Regex validation.                                  |

			🔧 Miscellaneous Annotations
						| Annotation                              | Description                                 |
						| --------------------------------------- | ------------------------------------------- |
						| `@Access(AccessType.FIELD or PROPERTY)` | Defines how JPA accesses fields/properties. |
						| `@NamedQuery`                           | Declares static named JPQL queries.         |
						| `@NamedQueries`                         | Group of `@NamedQuery` annotations.         |
						| `@SqlResultSetMapping`                  | Maps SQL result sets to entities.           |
						| `@Converter`                            | Converts custom types to DB-friendly types. |





					
			-- 🟨 3. XML-Based Configuration
						Instead of annotations, you can define mapping in an external .hbm.xml file.
						<hibernate-mapping>
							    <class name="com.example.Employee" table="employee">
							        <id name="id" column="id">
							            <generator class="increment"/>
							        </id>
							        <property name="name" column="emp_name"/>
							    </class>
							</hibernate-mapping>
						
						In hibernate.cfg.xml:
							<mapping resource="Employee.hbm.xml"/>
							
			🔁 4. Comparison: Annotations vs XML
						| Feature                  | Annotations                              | XML Configuration                        |
						| ------------------------ | ---------------------------------------- | ---------------------------------------- |
						| **Location**             | Inside Java classes                      | External `.hbm.xml` files                |
						| **Readability**          | Easy and concise for small projects      | Better separation for large applications |
						| **Refactoring Friendly** | Breaks if class is renamed               | No issue if class is renamed             |
						| **Tool Support**         | IDE auto-completion, compile-time errors | No compile-time validation               |
						| **Ease of Use**          | Less verbose                             | More verbose                             |
						| **Maintainability**      | Difficult in large projects              | Easier to manage mappings separately     |
						| **Performance**          | Almost same                              | Same                                     |

						
					🧪 When to Use What?
							| Scenario                              | Recommended Approach |
						| ------------------------------------- | -------------------- |
						| Small projects / quick development    | Annotations          |
						| Large projects / layered architecture | XML configuration    |
						| Need to switch mappings at runtime    | XML                  |
						| Strong IDE and type safety required   | Annotations          |
						
						
## Lecture 8: Hibernate Mapping (One-to-One, One-to-Many, Many-to-One, Many-to-Many)
					🔰 Types of Relationships in Hibernate
							
						| Relationship Type | Description                                                        |
						| ----------------- | ------------------------------------------------------------------ |
						| One-to-One        | One entity is associated with exactly one other entity             |
						| One-to-Many       | One entity is associated with multiple instances of another entity |
						| Many-to-One       | Many entities are associated with one instance of another entity   |
						| Many-to-Many      | Multiple instances of both entities are related to each other      |

				
				
					
								


	

	

