# Generics

```cs
// ---------- GENERIC CLASS ----------
 
class KeyValue<TKey, TValue>
{
	public TKey key { get; set; }
    public TValue value { get; set; }
 
    public KeyValue(TKey k, TValue v)
    {
    	key = k;
        value = v;
    }
 
    public void showData()
    {
    	Console.WriteLine("{0} is {1}", this.key, this.value);
    }
}
```
