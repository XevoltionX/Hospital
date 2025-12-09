<script setup>
import { ref } from 'vue'

// 设备列表数据（可根据实际需求从接口获取）
const orderList = ref([
  {
    id: '000001', 
    require: '李依',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000002',
    require: '二狗',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000003',
    require: '徐三',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  },
  {
    id: '000004',
    require: '吴四',
    createtime: '2004-09-03',
    Text: '查看详情'
  }
])

</script>

<template>
	<view class="index-container">
		<!-- 订单显示 -->
				<view class="chosen-container">
					<view class="chosen-box">
						<view class="chosen">
							物资编号
						</view>
						<view class="chosen">
							申请人员
						</view>
						<view class="chosen">
							创建时间
						</view>
					</view>
					<view class="order-container">
						<!-- 设备列表项（循环渲染） -->
						<view class="order-item" v-for="(order, idx) in orderList" :key="idx">
						  <!-- 设备信息区（图标+名称+状态） -->
						  <view class="order-info">
						    <view class="order-meta">
						      <text class="order-id">{{ order.id }}</text>
						      <text class="order-require">{{ order.require }}</text>
							  <text class="order-createtime">{{ order.createtime }}</text>
						    </view>
						  </view>
						  <!-- 操作按钮 -->
						  <button class="order-btn" @click="handleOperate(order)">{{ order.btnText }}</button>
						</view>
					</view>
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
	color: black;
	font-size: 50rpx;
	font-weight: 550;
	text-align: center;
	width: 100%;
}
.chosen-container{
	border-radius: 50rpx;
	background-color: #5a978f;
	margin: 0rpx 10rpx 20rpx 0rpx;
	display: flex;
	flex-direction: column;
}
.chosen-box{
	display: flex; /* 启用Flexbox */
	width: 100%;
	gap: 0; /* 栏之间的间距 */
}
.chosen{
	flex: 1;
	text-align: center;
	font-size: 35rpx;
	font-weight: 550;
	
}
.order-container{
	border-radius: 0rpx;
	background-color: #005f51;
	display: flex;
	flex-direction: column;
}
.order-item{
	display: flex; 
	align-items: center; 
	justify-content: space-between;
	margin: 10rpx 0 10rpx 0;
	border-bottom: 2px dashed #002621;
	border-right: 10px solid #5a978f;
	border-radius: 10rpx;
}
.order-info{
	display: flex;
	min-width: 100%;
	align-items: center;
	margin-top: 0rpx;
	
}
.order-meta{
	border-color: #002621;
	border-width: 100rpx;
	display: flex; width: 100%;
	gap: 10rpx;
}
.order-id{
	flex: 1; text-align: center;
	font-size: 35rpx;
	font-weight: 550;
}
.order-require{
	flex: 1; text-align: center;
	font-size: 35rpx;
	font-weight: 550;
}
.order-createtime{
	flex: 1; text-align: center;
	font-size: 35rpx;
	font-weight: 550;
}
</style>