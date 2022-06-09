enum class PhoneType(){
    HOME, WORK, PERSONAL
}

data class UserContact( val number: Contact.PhoneNumber,
                        val email: Contact.Email,
                        val messenger: Contact.Messenger)

sealed class Contact(){
    data class PhoneNumber(val type : PhoneType, val number:String) : Contact()
    data class Email(val email: String) : Contact()
    data class Messenger(val name: String, val id:Int)
}

data class User(val firstName: String,
                val lastName: String,
                val age: Int,
                val contacts: MutableList<UserContact>)
{

}


fun main(args: Array<String>){
    val users: List<User> = listOf(
        User("Jim","Jones",22, mutableListOf(
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "123"),Contact.Email("123@"),Contact.Messenger("tg",1)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "1234"),Contact.Email("1234@"),Contact.Messenger("vk",2)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "12345"),Contact.Email("12345@"),Contact.Messenger("m3",3))
            )
        ),
        User("Petya","Petrov",45, mutableListOf(
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "abc"),Contact.Email("abc@"),Contact.Messenger("m1",11)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "abcd"),Contact.Email("abcd@"),Contact.Messenger("m2",12)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "abcde"),Contact.Email("abcde@"),Contact.Messenger("m3",13))
            )
        ),
        User("Mikola","Ivanov",30, mutableListOf(
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "qwe"),Contact.Email("qwe@"),Contact.Messenger("any1",101)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "qwer"),Contact.Email("qwer@"),Contact.Messenger("any2",102)),
            UserContact(Contact.PhoneNumber(PhoneType.PERSONAL, "qwert"),Contact.Email("qwert@"),Contact.Messenger("any3",103))
        )
        )
    )
    for(i in users.indices)println(users[i])
}
