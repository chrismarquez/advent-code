import com.christopher.*
import org.junit.Assert
import org.junit.Test
import java.io.FileReader

class Tests {

    @Test
    fun test1A() {
        val reader = FileReader("input1.txt")
        val lines = reader.readLines()
        val result = addFrequencies(lines.map(String::toInt))
        Assert.assertEquals(547, result)
    }

    @Test
    fun test1B() {
        val reader = FileReader("input1.txt")
        val lines = reader.readLines()
        val result = findDuplicateFreq(lines.map(String::toInt))
        Assert.assertEquals(76414, result)
    }

    @Test
    fun test2A() {
        val reader = FileReader("input2.txt")
        val lines = reader.readLines()
        val result = findIdChecksum(lines)
        Assert.assertEquals(3952, result)
    }

    @Test
    fun test2B() {
        val reader = FileReader("input2.txt")
        val lines = reader.readLines()
        val result = findCommonIds(lines)
        Assert.assertEquals("vtnikorkulbfejvyznqgdxpaw", result)
    }

    @Test
    fun test4A() {
        val reader = FileReader("input4.txt")
        val lines = reader.readLines()
        val result = findSleepyGuard(lines)
        Assert.assertEquals(8421, result)
    }

    @Test
    fun test4B() {
        val reader = FileReader("input4.txt")
        val lines = reader.readLines()
        val result = findSleepyGuardAlt(lines)
        Assert.assertEquals(83359, result)
    }


}