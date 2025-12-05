<script setup>
import { ref,onMounted } from 'vue'
import { onReady,onShow} from '@dcloudio/uni-app'

const chartData = ref({})
const chartDataPie = ref({})
const hasNotification = ref(true)
const opts = ref({
  color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
  padding: [15,15,0,5],
  touchMoveLimit: 24,
  enableScroll: true,
  legend: {},
  xAxis: {
    disableGrid: true,
    scrollShow: true,
    itemCount: 4
  },
  yAxis: {
    data: [{ min: 0 }]
  },
  extra: {
    column: {
      type: "group",
      width: 30,
      activeBgColor: "#000000",
      activeBgOpacity: 0.08
    },
	pie: {
	  activeOpacity: 0.5,
	  activeRadius: 10,
	  offsetAngle: 0,
	  border: false,
	  borderWidth: 3,
	  borderColor: "#FFFFFF",
	}
  }
})

// 4. 获取数据方法
const getServerData = () => {
  // 模拟请求延时
  setTimeout(() => {
    const res = {
      categories: ["2018","2019","2020","2021","2022","2023"],
      series: [
        { name: "目标值", data: [35,36,31,33,13,34] },
        { name: "完成量", data: [18,27,21,24,6,28] }
      ]
    };
	const resP = {
	  series: [
	    {
	      data: [{"name":"一班","value":50},{"name":"二班","value":30},{"name":"三班","value":20},{"name":"四班","value":18},{"name":"五班","value":8}]
	    }
	  ]
	};
    chartData.value = JSON.parse(JSON.stringify(res)); 
	chartDataPie.value = JSON.parse(JSON.stringify(resP));
  }, 1000);
}

const showNotifications = () => {
	uni.showToast({
		title: '查看通知',
		icon: 'none'
	})
}

const goToProfile = () => {
	uni.navigateTo({
		url: '/pages/user/user'
	})
}

// 5. 生命周期（页面就绪后加载数据）
onShow(() => {
	getServerData();
})
// 可选：如需手动刷新数据，可暴露方法（比如绑定按钮点击）
// const refreshData = () => {
//   getServerData()
// }
</script>

<template>
	<view class="index-container">
		<!-- 头部搜索栏 -->
				<view class="header">
					<view class="search-bar">
						<image src="/static/icon/search.png" class="search-icon"></image>
						<input type="text" placeholder="搜索..." class="search-input" />
					</view>
					<view class="header-actions">
						<view class="notification-btn" @tap="showNotifications">
							<text class="notification-icon">🔔</text>
							<view class="notification-badge" v-if="hasNotification">3</view>
						</view>
						<view class="avatar" @tap="goToProfile">
							<image src="../../static/user.png" class="avatar-img"></image>
						</view>
					</view>
				</view>
		<!-- 柱图 -->
		<view class="charts-box">
			    <view class="title-box">
			      <text class="title-text">柱状图数据统计</text>
			    </view>
				<view class="Culcharts">
					<qiun-data-charts
					type="column"
					:opts="opts"
					:chartData="chartData"
					:ontouch="true"
					/>
				</view>
		</view>
		<!-- 饼图 -->
		   <view class="charts-box-line">
			   <qiun-data-charts 
			   		type="pie"
			   		:opts="opts"
			   		:chartData="chartDataPie"
			   	/>
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
/* 头部样式 */
.header {
	display: flex;
	align-items: center;
	padding: 20rpx 30rpx;
	background-color: #00554b;
	box-shadow: 0 2rpx 10rpx rgba(0, 0, 0, 0.1);
}

.search-bar {
	flex: 1;
	display: flex;
	align-items: center;
	background-color: #f5f5f5;
	border-radius: 50rpx;
	padding: 20rpx 30rpx;
	margin-right: 20rpx;
}

.search-icon {
	width: 32rpx;
	height: 32rpx;
	margin-right: 15rpx;
}

.search-input {
	flex: 1;
	font-size: 28rpx;
	color: #333;
}

.header-actions {
	display: flex;
	align-items: center;
}

.notification-btn {
	position: relative;
	margin-right: 20rpx;
}

.notification-icon {
	font-size: 40rpx;
	color: #666;
}

.notification-badge {
	position: absolute;
	top: -8rpx;
	right: -8rpx;
	background-color: #ff4757;
	color: #fff;
	font-size: 20rpx;
	padding: 4rpx 8rpx;
	border-radius: 20rpx;
	min-width: 30rpx;
	text-align: center;
}

.avatar {
	width: 60rpx;
	height: 60rpx;
	border-radius: 50%;
	overflow: hidden;
}

.avatar-img {
	width: 100%;
	height: 100%;
}
.charts-box {
    width: 90%;
    height: 400px;
	background-color: #fff;
	margin: 50rpx 30rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.Culcharts{
	width: 90%;
	height: 300px;
	background-color: #fff;
	margin: 50rpx 30rpx;
	border-radius: 20rpx;
	padding: 10rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
	display: flex;
}
.charts-box-line {
    width: 90%;
    height: 300px;
	background-color: #fff;
	margin: 50rpx 30rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.charts-box-radius-in {
    width: 45%;
    height: 200px;
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

.title-box {
  text-align: center; 
  margin: 30rpx 0;
}

.title-text {
  font-weight: bold; 
  font-size: 42rpx;
  color: #333; 
  height: 50rpx;
}
</style>




