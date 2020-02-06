package ro.dobrescuandrei.timelineviewv2.model

import android.annotation.SuppressLint
import android.content.res.Resources
import org.joda.time.DateTime
import ro.dobrescuandrei.timelineviewv2.TimelineViewDefaults
import ro.dobrescuandrei.timelineviewv2.utils.atBeginningOfDay
import ro.dobrescuandrei.timelineviewv2.utils.atEndOfDay
import ro.dobrescuandrei.timelineviewv2.utils.formatJodaDateTime
import java.text.SimpleDateFormat

class CustomDateTimeInterval : DateTimeInterval<CustomDateTimeInterval>
{
    constructor(fromDateTime : DateTime, toDateTime : DateTime) : super(
        fromDateTime = fromDateTime.atBeginningOfDay(),
        toDateTime = toDateTime.atEndOfDay())

    override fun getPreviousDateTimeInterval() : CustomDateTimeInterval? = null
    override fun getNextDateTimeInterval(): CustomDateTimeInterval? = null

    @SuppressLint("SimpleDateFormat")
    override fun toString(resources : Resources) : String
    {
        val now=DateTime.now(TimelineViewDefaults.timezone)!!

        val startDateTimeFormatter=
            if (fromDateTime.year!=now.year)
                SimpleDateFormat("dd MMM yyyy")
            else SimpleDateFormat("dd MM")
        startDateTimeFormatter.timeZone=TimelineViewDefaults.timezone.toTimeZone()!!
        val startDateStr=startDateTimeFormatter.formatJodaDateTime(fromDateTime)

        val endDateTimeFormatter=
            if (toDateTime.year!=now.year)
                SimpleDateFormat("dd MMM yyyy")
            else SimpleDateFormat("dd MMM")
        startDateTimeFormatter.timeZone=TimelineViewDefaults.timezone.toTimeZone()!!
        val endDateStr=endDateTimeFormatter.formatJodaDateTime(toDateTime)

        return "$startDateStr - $endDateStr"
    }
}