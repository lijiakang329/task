
-- checkandset.lua
local current = redis.call('GET', "myhash")
local currentNum = tonumber(current);
local argvNum = tonumber(ARGV[1]);
if currentNum > 0 and (currentNum-argvNum)>=0
  then redis.call('DECRBY', "myhash",argvNum)
  return "成功！！！"
end
return "失败！！！"