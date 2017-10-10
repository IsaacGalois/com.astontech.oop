package com.astontech.console;

import LabObjects.Lab5.Commutes;
import LabObjects.Lab5.Driver;
import LabObjects.Lab5.StringFlip;
import com.astontech.bo.*;
import com.astontech.bo.interfaces.Home;
import com.astontech.bo.interfaces.ILocation;
import com.astontech.bo.interfaces.Site;
import com.astontech.dao.*;
import com.astontech.dao.mysql.EmployeeDAOImpl;
import com.astontech.dao.mysql.*;
import com.astontech.dao.mysql.PersonDAOImpl;
import common.helpers.MathHelper;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //notes: private static method  for the lesson
//        LessonDataTypes();
//        LessonLists();
//        LessonOperators();
//        LessonFlowControl();
//        LessonExceptions();
//        LessonClassObjects();
//        LessonMethods();

//        LessonObjectsLAB();

//        LessonCollections();
//        LessonComplexProperties();

//        LessonCollectionsLAB();

//        LessonInstanceVsStatic();
//        LessonPolymorphism();
//        LessonHash();
//        LessonValueVsRef();

//        Lab4();


//        LessonInterfacesTest();
//        LessonLogging();

//        Driver steve = new Driver();
//        Lab5(steve);

//        LessonDBConnection();
//        LessonExecQuery();
//        GetStoredProc();
//        DbLab();

//        LessonDAO();

//        DbLab2();

//        LessonDAOInsert();

//        LessonDAOUpdate();

//        LessonDAODelete();

//        DbLab3();

//        LessonReflectionAndGenerics(ArrayList.class);

//        LessonBoxUnboxCasting();

//        LessonSerialization();
//        LessonDeSerialization();

//        LessonRecursion(25);
        File dir = new File(".");
        LessonRecursionComplex(dir);


    }

    private static void LessonRecursionComplex(File dir) {
        try {
            File[] files = dir.listFiles();
            for(File file: files) {
                if(file.isDirectory()) {
                    System.out.println("directory: "+file.getCanonicalPath());
                    LessonRecursionComplex(file);
                }
                else {
                    System.out.println("file: "+file.getCanonicalPath());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void LessonRecursion(int recCount) {
        System.out.println("RecCount = "+recCount);
        if (recCount > 0) {
            LessonRecursion(recCount-1);
        }
    }

    private static void LessonSerialization() {
        //get an object from database
        PersonDAO pd = new PersonDAOImpl();
        Person dave = pd.getPersonById(1);

        //serialize to a text file
        try {
            FileOutputStream fileOut = new FileOutputStream("./ser_person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dave);
            out.close();
            fileOut.close();
        } catch (Exception io) {
            System.out.println(io.toString());
        }
    }

    private static void LessonDeSerialization() {
        Person steve = null;
        try {
            FileInputStream fileIn = new FileInputStream("./ser_person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            steve = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch(Exception io) {
            io.printStackTrace();
        }

        System.out.println("Steve= "+steve.ToString());


    }

    private static void LessonBoxUnboxCasting() {
        //Boxing: the act of converting a value type to a ref type. primitive --> Class

        //Boxing:
        int x = 10;
        Object o = x;
        LessonReflectionAndGenerics(o.getClass());

        //Unboxing:
        int y = (int) o; //<--Casting (specifically 'explicit casting')

        //implicit casting
        int i = 100;
        double d = i; //<-- d is i cast as a double

    }

    private static <T> void LessonReflectionAndGenerics(Class<T> genericClass) {

        logger.info("Full Name: "+ genericClass.getName());
        logger.info("Simple Name: "+genericClass.getSimpleName());
        for(Field field:genericClass.getDeclaredFields()) {
            logger.info("Field: "+field.getName() + "- Type: "+field.getType());
        }
        for(Method method: genericClass.getDeclaredMethods()) {
            logger.info("Method: " + method.getName());
        }
    }

    private static void DbLab3() {

        //insert employee
//        Employee anEmployee = new Employee();
//        anEmployee.setBirthDate(new java.sql.Date(12));
//        anEmployee.setPersonId(8);
//
//        EmployeeDAO ebridge = new EmployeeDAOImpl();
//        int eid = ebridge.insertEmployee(anEmployee);
//
//        logger.info("New Employee Record Inserted. ID = "+eid);

        //update
//        Employee steve = ebridge.getEmployeeById(8);
//
//        steve.setPersonId(8);
//        steve.setBirthDate(new java.sql.Date(44));
//
//        System.out.println("Updated steve "+ebridge.updateEmployee(steve));

        //delete
//        System.out.println("Deleted steve "+ebridge.deleteEmployee(8));

        //insert Phone
//        Phone aPhone = new Phone();
//        aPhone.setPhoneNumber(1239996);
//        EntityType type = new EntityType();
//        type.setEntityTypeId(7);
//        aPhone.setPhoneType(type);
//        aPhone.setClientId(1);
//        aPhone.setPersonId(1);
//
//        PhoneDAO phoneDAO = new PhoneDAOImpl();
//        int phid = phoneDAO.insertPhone(aPhone);
//
//        logger.info("New Phone Record Inserted. ID = "+phid);

        //update
//        Phone newNum = phoneDAO.getPhoneById(40);
//        newNum.setPhoneNumber(4545454);
//
//        System.out.println("Updated newNum "+phoneDAO.updatePhone(newNum));

        //delete
//        System.out.println("Deleted newNum "+phoneDAO.deletePhone(40));

        //insert email
//        Email anEmail = new Email();
//        anEmail.setEmailAddress("afake@address.com");
//        anEmail.setEmployeeId(3);
//        EntityType eType = new EntityType();
//        eType.setEntityTypeId(1);
//        anEmail.setEmailType(eType);

//        EmailDAO EmailDAO = new EmailDAOImpl();
//        int emid = EmailDAO.insertEmail(anEmail);

//        logger.info("New Email Record Inserted. ID = "+emid);

        //update
//        Email newEmail = EmailDAO.getEmailById(13);
//
//        newEmail.setEmailAddress("newadd@ress.com");
//
//        System.out.println("Updated newEmail "+EmailDAO.updateEmail(newEmail));

        //delete
//        System.out.println("Deleted newEmail "+EmailDAO.deleteEmail(13));

        //insert Vehicle
//        Vehicle aVehicle = new Vehicle();
//        aVehicle.setVin("ABC123");
//        VehicleModel goo = new VehicleModel();
//        goo.setVehicleModelId(10);
//        aVehicle.setVehicleModel(goo);
//
//        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
//        int vid = vehicleDAO.insertVehicle(aVehicle);
//
//        logger.info("New Vehicle Record Inserted. ID = "+vid);

        //update
//        Vehicle newVehicle = vehicleDAO.getVehicleById(19);
//
//        newVehicle.setVin("TONE-E");
//
//        System.out.println("Updated newVehicle "+vehicleDAO.updateVehicle(newVehicle));

        //delete
//        System.out.println("Deleted newVehicle "+vehicleDAO.deleteVehicle(19));

        //insert vehiclemake
//        VehicleMake aVM = new VehicleMake();
//        aVM.setVehicleMakeName("Renault");
//
//        VehicleMakeDAO vmDAO = new VehicleMakeDAOImpl();
//        int vmid = vmDAO.insertVehicleMake(aVM);
//
//        logger.info("New VehicleMake Record Inserted. ID = "+vmid);

        //update
//        VehicleMake newVM = vmDAO.getVehicleMakeById(7);
//
//        newVM.setVehicleMakeName("Rolls Royce");
//
//        System.out.println("Updated newVM "+vmDAO.updateVehicleMake(newVM));

        //delete
//        System.out.println("Deleted newVM "+vmDAO.deleteVehicleMake(7));

        //insert vehiclemodel
//        VehicleModel aVMO = new VehicleModel();
//        aVMO.setVehicleModelName("Eurobus");
//        VehicleMake foo = new VehicleMake();
//        foo.setVehicleMakeId(5);
//        aVMO.setVehicleMake(foo);
//
//        VehicleModelDAO vmoDAO = new VehicleModelDAOImpl();
//        int vmoid = vmoDAO.insertVehicleModel(aVMO);
//
//        logger.info("New VehicleModel Record Inserted. ID = "+vmoid);

        //update
//        VehicleModel newVMO= vmoDAO.getVehicleModelById(15);
//
//        newVMO.setVehicleModelName("FireBird");
//
//        System.out.println("Updated newVMO "+vmoDAO.updateVehicleModel(newVMO));

        //delete
//        System.out.println("Deleted newVMO "+vmoDAO.deleteVehicleModel(15));
    }

    private static void LessonDAODelete() {
        PersonDAO bridge = new PersonDAOImpl();

        System.out.println("Deleted iron man "+bridge.deletePerson(11));
    }

    private static void LessonDAOUpdate() {
        PersonDAO bridge = new PersonDAOImpl();
        Person tony = bridge.getPersonById(10);

        tony.setFirstName("TONE-E");

        System.out.println("Updated iron man "+bridge.updatePerson(tony));
    }

    private static void LessonDAOInsert() {
        Person aPerson = new Person();
        aPerson.setTitle("Dr.");
        aPerson.setFirstName("Tony");
        aPerson.setLastName("Stark");
        aPerson.setDisplayFirstName("Iron Man");
        aPerson.setGender("M");

        PersonDAO personDAO = new PersonDAOImpl();
        int id = personDAO.insertPerson(aPerson);

        logger.info("New Person Record Inserted. ID = "+id);
    }

    private static void DbLab2() {
        EmployeeDAOImpl EmpGet = new EmployeeDAOImpl();
        PhoneDAOImpl PhoneGetter = new PhoneDAOImpl();
        EmailDAOImpl emailGet = new EmailDAOImpl();
        VehicleDAOImpl vehicleGet = new VehicleDAOImpl();
        VehicleModelDAOImpl vmGet = new VehicleModelDAOImpl();
        VehicleMakeDAOImpl vmaGet = new VehicleMakeDAOImpl();

        List<Employee> eList = EmpGet.getEmployeeList();
        for(Employee e:eList)
            System.out.println(e.getCreateDate());

        for(Phone p:PhoneGetter.getPhoneList())
            System.out.println(p.getPhoneNumber());

        for(Email em:emailGet.getEmailList())
            System.out.println(em.getEmailAddress());

        for(Vehicle v:vehicleGet.getVehicleList())
            System.out.println(v.getVehicleId());

        for(VehicleModel vm:vmGet.getVehicleModelList())
            System.out.println(vm.getVehicleModelName());

        for(VehicleMake vmake:vmaGet.getVehicleMakeList())
            System.out.println(vmake.getVehicleMakeName());
    }

    private static void LessonDAO() {
        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl(); //amend in next lesson
        List<Person> personList = personDAO.getPersonList();

        System.out.println("====================================");

        for(Person person:personList) {
            System.out.println(person.getPersonId()+") "+person.getLastName()+", "+person.getFirstName());
        }

        System.out.println("====================================");
        //endregion

        //region PROMPT USER
        Scanner darkly = new Scanner(System.in);
        System.out.print("Please select a Person from list by index: ");
        String personId = darkly.nextLine();
        //endregion

        //region GET PERSON DETAILS
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("-----------Person Details---------------");
        System.out.println("PersonID: "+personDetail.getPersonId());
        System.out.println("Full Name: "+personDetail.GetFullName());
        System.out.println("Gender: "+personDetail.getGender());
        //endregion
    }

    private static void DbLab() {
        String dbHost = "localhost";
        String dbPort = "1433";
        String dbVersion = "\\SQLEXPRESS";
        String dbName = "TestDB";
        String dbUser = "SA";
        String dbPass = "NBonaparte1812";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            logger.error("MSSQL Server Driver not found! " + ex);
            return;
        }

        logger.info("SQL Server Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:"+dbPort+";databasename="+dbName,dbUser,dbPass);

            logger.info("Successfully connected to MySQL database");
            Statement stmt = connection.createStatement();
            String sql = "Select * from Inventory";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n+----------Inventory Table--------------------------------+");
            while(rs.next()) {
                System.out.println("| ItemId: "+rs.getInt(1)+"  | ItemName: "+rs.getString(2)+"    | ItemQuantity: "+rs.getInt(3)+"    |");
            }
            System.out.println("+---------------------------------------------------------+");

            connection.close();
        } catch (SQLException ex) {
            logger.error("Connection Failed! " + ex);
            return;
        }
    }

    private static void GetStoredProc() {
        Connection conn = LessonDBConnection();

        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1,20);
            cStmt.setInt(2,5);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                logger.info(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }

        } catch(SQLException sqlEx) {
            logger.error(sqlEx);
        }

    }

    private static void LessonExecQuery() {
        Connection conn = LessonDBConnection();

        try {
            Statement stmt = conn.createStatement();
            String sql = "Select PersonId, FirstName from Person";

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                logger.info("PersonId: "+rs.getInt(1)+", FirstName: "+rs.getString(2));
            }
            conn.close();

        } catch(SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static Connection LessonDBConnection() {
        String dbHost = "localhost";
        String dbName = "AstonEngineer";
        String dbUser = "consoleUser";
        String dbPass = "qwe123$!";
        String useSSL = "false";
        String procBod = "true";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found! " + ex);
            return null;
        }

        logger.info("MySQL Driver Registered.");
        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://"+dbHost+":3306/"+dbName+"?useSSL="+useSSL+"&noAccessToProcedureBodies="+procBod,dbUser,dbPass);

        } catch (SQLException ex) {
            logger.error("Connection Failed! " + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to MySQL database");
        } else {
            logger.info("Connection Failed");
            return null;
        }

        return connection;
    }

    private static void LessonLogging() {
        //notes: levels of logging
        logger.debug("This is a DEBUG log message");    //highest level
        logger.info("This is an INFO log message");

        //notes: production levels
        logger.warn("This is a WARN log message");
        logger.error("This is an ERROR log message");
        logger.fatal("This is a FATAL log message");    //lowest level

        //notes: log an exception
        try {
            int i = 10 / 0;
        } catch(ArithmeticException ex) {
            logger.error("An exception occurred: " + ex);
        }
    }

    private static void Lab5(Commutes steve) {
        //3) When people commute to work but do so using different transport
        System.out.println("Steve takes a "+steve.getCommuteMethod()+" to work and it takes "+steve.getCommuteTime()+" minutes");

        StringFlip flipMe = new StringFlip("What in the world?");
        System.out.println(flipMe.Flip());

    }

    private static void LessonInterfacesTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachines(2);
        MN010.setConferenceRooms(1);
        MN010.setCubicles(8);
        MN010.setOffices(6);
        MN010.setTrainingDesks(36);

        Home BipsHouse = new Home();
        BipsHouse.setAddress("1 Main Street");
        BipsHouse.setOwner(new Employee("Bipin","Butala"));

        LessonInterfaces(MN010);
        LessonInterfaces(BipsHouse);

    }

    private static void LessonInterfaces(ILocation Ilocation) {
        System.out.println("====================");
        System.out.println("Location Name " + Ilocation.getLocationName());
        System.out.println("Number of workspaces " + Ilocation.numberOfWorkspaces());
        System.out.println("Can Have Meetings "+ Ilocation.canHaveMeetings());
        System.out.println("Has Coffee "+Ilocation.hasCoffee());
        System.out.println("====================");
    }

    private static void Lab4() {
        //1) An instance is an occurance of a class, while static implies a method that belongs to the class itself

        //2) a value type is a primitive data type which is referred to by its value directly. A reference type is
        //      is a type that is referred to by its memory address.

        Hashtable<Integer,String> projPatSongs = new Hashtable<>();
        projPatSongs.put(1,"Chicken Head");
        projPatSongs.put(2,"I ain't goin' back to jail");
        projPatSongs.put(3,"Aggravated Robbery");

        HashMap<Integer,String> frankZappaSongs = new HashMap<>();
        frankZappaSongs.put(1,"Eat that question");
        frankZappaSongs.put(2,"Yellow Snow");
        frankZappaSongs.put(3,"Valley Girl");

        HashSet<String> pFunkSongs= new HashSet<>();
        pFunkSongs.add("The Electric Spanking of War Babies");
        pFunkSongs.add("Mothership Connection");
        pFunkSongs.add("Who says a funk band can't play rock");

    }

    private static void LessonValueVsRef() {
        //notes: reference type = pointer
    }

    private static void LessonHash() {
        //notes: key-value pairs / value list

        //todo: HashTable
        /*
            1) does NOT allow null for either key or value
            2) synchronized, thread safe, but performance is decreased
            3) LIFO
         */
        System.out.println("---HASH TABLE---");

        Hashtable<Integer, String> firstHashTable = new Hashtable<>();
        firstHashTable.put(1,"inheritance");
        firstHashTable.put(2,"encapsulation");
        firstHashTable.put(3,"polymorphism");
        firstHashTable.put(4,"abstraction");

        System.out.println("Value from given key of 3: "+firstHashTable.get(3));
        for(Integer key: firstHashTable.keySet()) {
            System.out.println("key: "+key+", value: "+firstHashTable.get(key));
        }

        System.out.println("----------------");

        //todo: HashMap

        /*
            1) DOES allow null for either key or value
            2) un-synchronized, not thread safe, better performance
            3) FIFO
         */
        System.out.println("---HASH MAP----");

        HashMap<Integer,String> firstHashMap = new HashMap<>();
        firstHashMap.put(1,"inheritance");
        firstHashMap.put(2,"encapsulation");
        firstHashMap.put(3,"polymorphism");
        firstHashMap.put(4,"abstraction");

        System.out.println("Value from given key of 3: "+firstHashMap.get(3));
        for(Integer key: firstHashMap.keySet()) {
            System.out.println("key: "+key+", value: "+firstHashMap.get(key));
        }

        System.out.println("---------------");

        //todo: HashSet
        /*
            1) built in mechanism for duplicates
            2) used for where you want to maintain a unique list (list of unique values, no dupes)
         */
        System.out.println("---HASH SET----");
        HashSet<String> firstHashSet = new HashSet<>();

        firstHashSet.add("inheritance");
        firstHashSet.add("encapsulation");
        firstHashSet.add("polymorphism");
        firstHashSet.add("abstraction");
        firstHashSet.add("abstraction");

        for(String s: firstHashSet) {
            System.out.println(s);
        }

        if(firstHashSet.contains("adfdfd"))
            System.out.println("value exists");
        else
            System.out.println("value does not exist");
    }

    private static void LessonPolymorphism() {
        //notes: Polymorphism = many forms, same name
        //  Types: compile-time polymorphism and run-time polymorphism

        //compile-time polymorphism - overloaded
        //having two methods with the same name but different method signatures

        //run-time polymorphism - override
        //Vehicle.toString() an example of this <--I made a custom override of this method

    }

    private static void LessonInstanceVsStatic() {
//        Math myMath = new Math();

        System.out.println(MathHelper.square(4));

    }

    private static void LessonCollectionsLAB() {

        List<Vehicle> vehicleList = new ArrayList<>();

        VehicleMake chevy = new VehicleMake("Chevrolet");
        VehicleMake vw = new VehicleMake("Volkswagen");
        VehicleMake ford = new VehicleMake("Ford");

        VehicleModel vette = new VehicleModel("Corvette");
        VehicleModel cobalt = new VehicleModel("Cobalt");
        VehicleModel passat = new VehicleModel("Passat");
        VehicleModel jetta = new VehicleModel("Jetta");
        VehicleModel stang = new VehicleModel("Mustang");
        VehicleModel focus = new VehicleModel("Focus");

//        Vehicle aVette = new Vehicle(1997,chevy,vette);
//        Vehicle aCobalt = new Vehicle(2004,chevy,cobalt);
//        Vehicle aPassat = new Vehicle(2014,vw,passat);
//        Vehicle aJetta = new Vehicle(2005,vw,jetta);
//        Vehicle aStang = new Vehicle(2017,ford,stang);
//        Vehicle aFocus = new Vehicle(2015,ford,focus);

//        vehicleList.add(aVette);
//        vehicleList.add(aStang);
//        vehicleList.add(aPassat);
//        vehicleList.add(aFocus);
//        vehicleList.add(aJetta);
//        vehicleList.add(aCobalt);
//
//        for(Vehicle v: vehicleList) {
//            System.out.println(v.toString());
//        }

    }

    private static void LessonComplexProperties() {
        //notes: when to use inheritance (should answer the question 'IS A'
        //       when to use complex (nested) objects (should answer the question 'HAS A')

        EntityType emailWorkType = new EntityType("work");
        Email myEmail = new Email("bipin@bip.com");
        myEmail.setEmailType(emailWorkType);

        System.out.println(myEmail.getEmailAddress()+" type:"+myEmail.getEmailType().getEntityTypeName());

        //notes: collection/list of complex (nested) objects as a field
        Employee myEmployee = new Employee();
        myEmployee.getEmailList().add(new Email("test@test.com"));
        myEmployee.getEmailList().add(new Email("dan@test.com"));
        myEmployee.getEmailList().add(new Email("jason@test.com"));

        for(Email e: myEmployee.getEmailList()) {
            System.out.println(e.getEmailAddress());
        }

    }

    private static void LessonCollections() {
        //notes: List<T> - Generic Type 'T'
        List<Employee> employeeList = new ArrayList<>();

        Employee emp1 = new Employee("Dan","Simmer");
        Employee emp2 = new Employee("James","McRoberts");
        Employee emp3 = new Employee("Sean","Nilsen");
        Employee emp4 = new Employee("Adrian","Ratanyake");

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        employeeList.add(new Employee("John","Doe"));

        for (Employee e: employeeList) {
            System.out.println(e.GetFullName());
        }

    }

    private static void LessonClassObjects() {
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Bipin");
        myFirstPerson.setLastName("Butala");
        myFirstPerson.setTitle("Mr.");

        System.out.println(myFirstPerson.getTitle()+" "+myFirstPerson.getFirstName()+" "+myFirstPerson.getLastName());

        myFirstPerson.setId(3);
        System.out.println(myFirstPerson.getId());


    }

    private static void LessonMethods() {
        Employee constructorEmployee = new Employee("Bipin","Butala");
        System.out.println(constructorEmployee.GetFullName());
    }

    private static void LessonObjectsLAB() {
        //make an instance of each BO class
        Address anAddress = new Address(2164,"Cedar Drive");
        System.out.println("anAddress has AddressNum and Street = "+anAddress.getAddressNum()+" "+anAddress.getStreet());

        Client aClient = new Client("Best Buy");
        System.out.println("aClient has name = "+aClient.getClientName());

//        ClientContact aClientContract = new ClientContact(4);
//        System.out.println("ClientContact- ClientId = "+aClientContract.getClientId());

        Email anEmail = new Email("fake@notreal.com");
        System.out.println("anEmail has EmailAddress = "+anEmail.getEmailAddress());

        Employee steve = new Employee("Steve");
        System.out.println("anEmployee has name = "+steve.getFirstName());

//        EmployeeProject anEmployeeProject = new EmployeeProject(8);
//        System.out.println("EmployeeProject- ProjectId = "+anEmployeeProject.getProjectId());

        Entity anEntity = new Entity("Email");
        System.out.println("Entity = "+anEntity.getEntityName());

        EntityType anEntityType = new EntityType("Personal");
        System.out.println("EntityType = "+anEntityType.getEntityTypeName());

        LoyaltyAccount aLoyaltyAccount = new LoyaltyAccount(3);
        System.out.println("LoyaltyAccount: EmployeeId = " + aLoyaltyAccount.getEmployeeId());

        LoyaltyCompany aLoyaltyCompany = new LoyaltyCompany("Hertz");
        System.out.println("aLoyaltyCompany has name = "+aLoyaltyCompany.getCompanyName());

        Person aPerson = new Person("Dave");
        System.out.println("aPerson has first name = "+aPerson.getFirstName());

        Phone aPhone = new Phone(1234567);
        System.out.println("aPhone has PhoneNumber = "+aPhone.getPhoneNumber());

        Project aProject = new Project(7);
        System.out.println("aProject has ProjectId = "+aProject.getProjectId());

        ProjectStatus aProjectStatus = new ProjectStatus(7);
        System.out.println("aProjectStatus has ProjectId = "+aProjectStatus.getProjectId());

        Review aReview = new Review("Quarterly Review");
        System.out.println("aReview is a: "+aReview.getReviewName());

        ReviewData aReviewData = new ReviewData(6);
        System.out.println("aReviewData has ReviewId = "+aReviewData.getReviewId());

        Training aTraining = new Training("Web Services Training");
        System.out.println("aTraining is a: "+aTraining.getTrainingName());

        TrainingData aTrainingData = new TrainingData(4);
        System.out.println("aTrainingData has TrainingId = "+aTrainingData.getTrainingId());

        Vehicle aVehicle = new Vehicle("123ABC");
        System.out.println("aVehicle has license plate = "+aVehicle.getLicensePlate());

        VehicleMake aVehicleMake = new VehicleMake("Volkswagen");
        System.out.println("aVehicleMake is: "+aVehicleMake.getVehicleMakeName());

        VehicleModel aVehicleModel = new VehicleModel("Passat");
        System.out.println("aVehicleModel is: "+aVehicleModel.getVehicleModelName());

        VehicleStatus aVehicleStatus = new VehicleStatus(2);
        System.out.println("aVehicleStatus has VehicleId = "+aVehicleStatus.getVehicleId());

    }

    private static void LessonInheritance() {
        // 4 tenets of OOP: Encapsulation, Abstraction, Inheritance, and Polymorphism
        Employee employeeBip = new Employee();

        employeeBip.setFirstName("Bipin");
        employeeBip.setLastName("Butala");
        employeeBip.setTitle("Mr.");

        System.out.println(employeeBip.getTitle()+" "+employeeBip.getFirstName()+" "+employeeBip.getLastName());
    }

    private static void LessonExceptions() {

        try {
            String firstName = "Bipin";
            int x = Integer.parseInt(firstName);

            System.out.print("Integer value: ");
            System.out.println(x);
        } catch(IllegalArgumentException ex) {
            System.out.println("Exception: "+ex.toString());
            ex.printStackTrace();
        } catch(NullPointerException npex) {
            System.out.println("Exception: NullPointerException");
        } finally {
            System.out.println("Program has been completed regardless of exceptions.");
        }


    }

    private static void LessonFlowControl() {

        String name = "bipin";
        if(name.equals("bipin"))
            System.out.println("correct name");
        else
            System.out.println("incorrect name");

        switch(name) {
            case "bipin":
                break;
            default:
                System.out.println("Default");
                break;
        }

    }

    private static void LessonOperators() {
        int val = 10;
        System.out.println(val + 10);

        int modVal = 10 % 3;
        System.out.println("10%3 =");
        System.out.println(modVal);

        System.out.println("10/3 = <--Note: Integer Division");
        modVal = 10 / 3;
        System.out.println(modVal);

        // increment ++ / decrement --
        System.out.println("increment after: ");
        System.out.println("Val is "+val);
        System.out.println(val++ + 4);
        System.out.println("Val is "+val);
        System.out.println(++val + 4);
        System.out.println("Val is "+val);

        //logical operators: ==, !=, <=, >=, <, >
        boolean check = 12>=5;
        System.out.println("12 >= 5? " + check);

        //Logical And(&&) OR(||)
        //omitting



    }

    private static void LessonLists() {
        //notes: collections / Lists

        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("FirstString");
        myStringCollection.add("SecondString");
        myStringCollection.add("ThirdString");
        myStringCollection.add("FourthString");
        myStringCollection.add("FifthString");

        for(String i : myStringCollection) {
            System.out.println(i);
        }
    }

    private static void LessonDataTypes() {
        //notes: primitive data types
        // int
        // float
        // double
        // boolean
        // char

        //notes: common data types
        boolean myBool = false;
        int myInt = 4;
        String aString = "some words";
        Date aDate = new Date();
        String numString = "234";
        System.out.println(Integer.parseInt(numString));

    }

    private static void LessonVariables(){

        //notes: declare multiple variables and set

        //notes: create Scanner Object
        Scanner reader = new Scanner(System.in);

        //notes: prompt the user
        System.out.print("Enter your name: ");

        //notes: read input from the user and store it
        String input = reader.nextLine();

        //notes: print the value back to the console
        System.out.println("Hello " + input);


    }
}
