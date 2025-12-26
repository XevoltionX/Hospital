<template>
	<view class="my-chart">
	    <qiun-data-charts 
	    type="column"
	    :opts="optsColumn"
	    :chartData="chartDataColumn"
	    :ontouch="true"
	    />
	</view>
</template>

<script>
import { useColumnChart } from '@/component/column.js'
const { chartData: chartDataColumn , opts: optsColumn } = useColumnChart()

// 预留刷新接口
// const { chartData, opts, getServerData } = useColumnChart()
// const refreshData = () => {
//   getServerData()
// }
</script>

<style>
</style>