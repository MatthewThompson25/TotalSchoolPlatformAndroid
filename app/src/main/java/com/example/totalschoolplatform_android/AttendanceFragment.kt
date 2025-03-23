package com.example.totalschoolplatform_android

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kizitonwose.calendar.view.CalendarView
import com.kizitonwose.calendar.view.ViewContainer
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import org.threeten.bp.temporal.WeekFields
import java.util.Locale

class AttendanceFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private val presentDates = listOf(
        LocalDate.of(2025, 3, 10),
        LocalDate.of(2025, 3, 12)
    )

    private val absentDates = listOf(
        LocalDate.of(2025, 3, 11),
        LocalDate.of(2025, 3, 14)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attendance, container, false)
        /*
        calendarView = view.findViewById(R.id.calendarView)

        val currentMonth = YearMonth.now() // Now compatible with API 24+
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

        calendarView.setup(currentMonth.minusMonths(1), currentMonth.plusMonths(1), firstDayOfWeek)
        calendarView.scrollToMonth(currentMonth)

        calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()

                if (day.owner == DayOwner.THIS_MONTH) {
                    when (day.date) {
                        in presentDates -> container.textView.setBackgroundColor(Color.parseColor("#00C853")) // Green
                        in absentDates -> container.textView.setBackgroundColor(Color.parseColor("#D50000")) // Red
                        else -> container.textView.setBackgroundColor(Color.TRANSPARENT)
                    }
                } else {
                    container.textView.setBackgroundColor(Color.TRANSPARENT)
                }
            }
        }
    */
        return view
    }
    /*
    inner class DayViewContainer(view: View) : ViewContainer(view) {
        val textView: TextView = view.findViewById(R.id.calendarDayText)
    }
    */
    companion object {
        @JvmStatic
        fun newInstance() = AttendanceFragment()
    }
}


