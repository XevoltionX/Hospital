<script setup>
// 导入复用的柱状图逻辑
import { useColumnChart } from '@/component/column.js'
// import { usePieChart } from '@/component/pie.js'
const { chartData, opts } = useColumnChart()

// const { chartData, opts } = usePieChart()

// 预留刷新接口
// const { chartData, opts, getServerData } = useColumnChart()
// const refreshData = () => {
//   getServerData()
// }
</script>

<template>
	<view class="index-container">
		<!-- 柱图 -->
		<view class="charts-box">
		    <qiun-data-charts 
		       type="column"
		        :opts="opts"
		        :chartData="chartData"
		        :ontouch="true"
		     />
		   </view>
		 <!--  饼图 -->
		   <view class="charts-box-radius-out">
			   <view class="charts-box-radius-in">
				   wtf?
			   		
			   </view>
			   <view class="charts-box-radius-in">
			   		此乃圈图
			   </view>
		   </view>
		   <view class="charts-box">
			   <!-- <qiun-data-charts 
			   		type="pie"
			   		:opts="opts"
			   		:chartData="chartData"
			   	/> -->
		   </view> 
	</view>
</template>

<style>
.index-container {
	background-color: #00554b;
	min-height: 100vh;
	padding-bottom: 40rpx;
	padding-left: 20rpx;
	padding-right: 20rpx;
}	
.main-text{
	border-radius: 200rpx;
	color: black;
	font-size: 50rpx;
	text-align: center;

}
.charts-box {
    width: 90%;
    height: 300px;
	background-color: #fff;
	margin: 0rpx 30rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.charts-box-radius-in {
    width: 45%;
    height: 300px;
	background-color: #fff;
	margin: 50rpx 0rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.charts-box-radius-out {
  display: flex; 
  justify-content: space-between; 
  padding: 0 20rpx; 
}
</style>