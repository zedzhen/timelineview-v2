package ro.dobrescuandrei.timelineviewv2.recycler.adapter

import android.content.Context
import ro.dobrescuandrei.timelineviewv2.R
import ro.dobrescuandrei.timelineviewv2.TimelineView

class WeeklyDateIntervalAdapter : InfiniteScrollingTimelineRecyclerViewAdapter
{
    constructor(context: Context?, timelineView: TimelineView?) : super(context, timelineView)

    override fun getCellWidthInPixels() =
        150*context.resources.getDimensionPixelSize(R.dimen.one_dp)
}
