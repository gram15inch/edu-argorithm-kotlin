import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArrayTest {

    @Test
    fun arrayEditByParameter(){
        val a = IntArray(10){0}
        plus(a,0)
        assertEquals(1, a[0])
        plus(a,0)
        assertEquals(2, a[0])
        plus(a,0)
        assertEquals(3, a[0])
    }

    fun plus(a:IntArray,idx:Int){
        a[idx]++
    }
}