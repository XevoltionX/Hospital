<script setup>
import { ref } from 'vue'

// 设备列表数据（可根据实际需求从接口获取）
const deviceList = ref([
  {
    name: '石油机',
    icon: '/static/news.png', // 需自行准备图标并放入static目录
    status: '离线',
    statusType: 'status-offline',
    btnText: '查看详情'
  },
  {
    name: '运行车',
    icon: '/static/stock.png',
    status: '在线',
    statusType: 'status-online',
    btnText: '查看详情'
  },
  {
    name: '供热机',
    icon: '/static/stock.png',
    status: '运行中',
    statusType: 'status-running',
    btnText: '查看详情'
  },
  {
    name: '空调新风',
    icon: '/static/stock.png',
    status: '待机',
    statusType: 'status-standby',
    btnText: '查看详情'
  },
  {
    name: '运油车',
    icon: '/static/stock.png',
    status: '运输中',
    statusType: 'status-transport',
    btnText: '查看详情'
  }
])

// 操作按钮点击事件
const handleOperate = (device) => {
  uni.showToast({
    title: `点击了${device.name}的${device.btnText}`,
    icon: 'none'
  })
  // 可在这里添加实际业务逻辑（如调用接口、跳转页面等）
}
</script>

<template>
	<view class="index-container">
		<!-- 页面容器 -->
		  <view class="device-monitor-container">
		    <!-- 设备列表项（循环渲染） -->
		    <view class="device-item" v-for="(device, idx) in deviceList" :key="idx">
		      <!-- 设备信息区（图标+名称+状态） -->
		      <view class="device-info">
		        <image class="device-icon" :src="device.icon" mode="widthFix"></image>
		        <view class="device-meta">
		          <text class="device-name">{{ device.name }}</text>
		          <text class="device-status" :class="device.statusType">{{ device.status }}</text>
		        </view>
		      </view>
		      <!-- 操作按钮 -->
		      <button class="device-btn" @click="handleOperate(device)">{{ device.btnText }}</button>
		    </view>
		  </view>
	</view>
</template>

<style>
/* 页面容器样式 */
.device-monitor-container {
  background-color:#00554b;
  padding: 15rpx;
  min-height: 100vh;
}

/* 设备项卡片样式 */
.device-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: #fff;
  border-radius: 16rpx;
  padding: 20rpx;
  margin-bottom: 20rpx;
  box-shadow: 0 2rpx 8rpx rgba(0, 0, 0, 0.05);
}

/* 设备信息区样式 */
.device-info {
  display: flex;
  align-items: center;
  margin-top: 0rpx;
}
.device-icon {
  width: 80rpx;
  height: 80rpx;
  margin-right: 20rpx;
}
.device-meta {
  display: flex;
  align-items: center;
  margin-top: 0rpx;
}
.device-name {
  font-size: 32rpx;
  color: #333;
  margin-right: 15rpx;
  margin-top: 0rpx;
}

/* 设备状态标签样式 */
.device-status {
  font-size: 24rpx;
  padding: 4rpx 12rpx;
  border-radius: 12rpx;
  color: #fff;
}
.status-offline {
  background-color: #ff4d4f;
}
.status-online {
  background-color: #52c41a;
}
.status-running {
  background-color: #1890ff;
}
.status-standby {
  background-color: #faad14;
}
.status-transport {
  background-color: #722ed1;
}

/* 操作按钮样式 */
.device-btn {
  font-size: 28rpx;
  font-weight: 600;
  padding: 12rpx 24rpx;
  color: #fff;
  background-color: #00b388; /* 主色调匹配截图 */
  border-radius: 50rpx;
  margin: 100rpx 10rpx 10rpx 0;
}
</style>