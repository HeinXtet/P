## P(SharePreference)

This is simple SharePreference Android Library written with Kotlin. This support any data type (String,Int,..) and you can save and retrieve object and arraylist.

## How to use

1. Add Project Level Gradle

   ```Kotlin
   allprojects {
   		repositories {
   			maven { url 'https://jitpack.io' }
   		}
   	}
   ```

2. Add App Level Gradle

   ```Kotlin
   dependencies {
   	       compile 'com.github.HeinXtet:DeevDialog:0.1.2'
   	}
   ```

   ​

3. Ready To use.

   ## Prepare

   You can init on your Application.

   ```Kotlin
   class App : Application() {
       override fun onCreate() {
           super.onCreate()
           P.getInstance().init(this) //should need to add manifest with name 
       }
   }
   			    (or)
   			
   P.getInstance().init(this) // on your Activity class or Fragment class
   ```

   **Can store Any Data Type**

   ```kotlin
   /*Save Data*/
   P.getInstance().put(key,value) Put Any Data Type

   /*Retrive Data*/
   P.getInstance().get(key)
   ```

   **Can store Any Object**

   ```Kotlin
   data class Bio(var name: String, var age: Int, var bio: String? = null)
   var bio = Bio("Hein Htet",23,"love coding")
   /*Save Data*/
   P.getInstance().put("bio",bio) Put Any Data Type
   /*Retrive Data*/
   P.getInstance().get("bio",Bio::class.java)
   ```

   **Can store ArrayList**

   ```kotlin
   data class Bio(var name: String, var age: Int, var bio: String? = null)

   //init arraylist and put 
   var list = ArrayList<Bio>()
   list.add(Bio("Hein Htet",23,"love coding"))
   list.add(Bio("Hein Htet2",23,"love coding2"))

   /*Save Data*/
   P.getInstance().put("bio",list) Put Any Data Type
   /*Retrive Data*/
   P.getInstance().get("language_list", ArrayList<Bio>())
   ```

   **Can Check Object**

   ```kotlin
   P.getInstance().isContain(key) //return Boolean
   ```

   **Delete Object**

   ```Kotlin
   P.getInstance().delete("bio") //delete from storage
   ```

   ​