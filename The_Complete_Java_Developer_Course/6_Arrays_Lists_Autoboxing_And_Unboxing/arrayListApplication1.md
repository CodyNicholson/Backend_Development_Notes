# ArrayList Application 1

```java
public class GroceryList
{
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item)
    {
        groceryList.add(item);
    }

    public void printGroceryList()
    {
        System.out.println("You have " + groceryList.size() + " items on your grocery list");
        for (int i=0; i < groceryList.size(); i++)
        {
            System.out.println((i+1) + ". " + groceryList.get(i+1));
        }
    }

    public void modifyGroceryList(int position, String newItem)
    {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified");
    }

    public void removeGroceryListItem(int position)
    {
        String item = groceryList.get(position);
        groceryList.remove(position);
        System.out.println(item + " has been removed from the grocery list");
    }

    public String findItem(String searchItem)
    {
        int position = groceryList.indexOf(searchItem);
        if (position>=0)
        {
            return groceryList.get(position);
        }
        System.out.println("Could not find the searched item");
        return null;
    }
}
```
